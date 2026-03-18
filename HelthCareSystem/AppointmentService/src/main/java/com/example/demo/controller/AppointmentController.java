package com.example.demo.controller;

import com.example.demo.client.DoctorClient;
import com.example.demo.config.RabbitMQConfig;
import com.example.demo.entity.Appointment;
import com.example.demo.repository.AppointmentRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorClient doctorClient;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> createAppointment(@RequestBody Appointment appointment) {
        // 1. Fetch doctor from DoctorService via Feign
        try {
            var doctor = doctorClient.getDoctorById(appointment.getDoctorId());
            if (doctor == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Doctor with given ID not found.");
            }
            if (!doctor.isAvailability()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Doctor is currently unavailable.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Could not fetch doctor details.");
        }

        // 2. Save appointment
        appointment.setAppointmentDate(appointment.getAppointmentDate() != null ? appointment.getAppointmentDate() : LocalDateTime.now());
        appointment.setStatus("CONFIRMED");
        Appointment savedAppointment = appointmentRepository.save(appointment);

        // 3. Publish Event via RabbitMQ
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, savedAppointment);

        return ResponseEntity.ok(savedAppointment);
    }

}
