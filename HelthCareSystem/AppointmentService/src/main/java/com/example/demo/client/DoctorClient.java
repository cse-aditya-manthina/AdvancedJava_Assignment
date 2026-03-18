package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "DoctorService")
public interface DoctorClient {

    @GetMapping("/doctors/{id}")
    DoctorDto getDoctorById(@PathVariable("id") Long id);

}
