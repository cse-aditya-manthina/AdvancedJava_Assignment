package com.example.demo.service;

import com.example.demo.config.RabbitMQConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class NotificationListener {

    private static final Logger logger = LoggerFactory.getLogger(NotificationListener.class);

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void consumeAppointmentEvent(Map<String, Object> appointment) {
        logger.info("-----------------------------------------------------");
        logger.info("Consumed Appointment Event from RabbitMQ Queue: {}", RabbitMQConfig.QUEUE);
        logger.info("Appointment Details: {}", appointment);
        logger.info("Simulating Email/SMS notification to Patient: {}", appointment.get("patientName"));
        logger.info("Notification successfully sent! Appointment Status: {}", appointment.get("status"));
        logger.info("-----------------------------------------------------");
    }
}
