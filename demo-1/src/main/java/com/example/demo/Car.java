package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class Car implements Vehicle {
	public Car() {
		System.out.println("this is a car class");
	}
	
	@Override
	public void run() {
		System.out.println("car is running...");
	}

}
