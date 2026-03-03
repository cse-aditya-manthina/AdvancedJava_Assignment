package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("")
public class CreditCard implements Payment{

	@Override
	public void payment(double amount) {
		// TODO Auto-generated method stub
		System.out.println("credit card payment of RS."+amount+" successful");
	}
	
	

}
