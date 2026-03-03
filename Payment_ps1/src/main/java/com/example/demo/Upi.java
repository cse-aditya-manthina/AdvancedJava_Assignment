package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Upi implements Payment{

	@Override
	public void payment(double amount) {
		// TODO Auto-generated method stub
		System.out.println("upi payment of Rs. "+amount+" successful");
	}

}
