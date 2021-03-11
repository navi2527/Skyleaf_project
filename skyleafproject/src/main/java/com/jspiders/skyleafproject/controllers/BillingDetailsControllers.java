package com.jspiders.skyleafproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.skyleafproject.beans.BillingDetails;
import com.jspiders.skyleafproject.repository.BillingDetailsRepository;

@RestController
@RequestMapping("/Billing")
public class BillingDetailsControllers 
{	
	@Autowired
	private BillingDetailsRepository repository;
	
	@GetMapping("/readAll")
	public Iterable<BillingDetails> readAll()
	{
		Iterable<BillingDetails> readall = repository.findAll();
		return readall;
	}
}
