package com.jspiders.skyleafproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.skyleafproject.beans.CardExpiry;
import com.jspiders.skyleafproject.repository.CardExpiryRepository;



	@RestController
	@RequestMapping("/cardexpiry")
	public class CardExpiryControllers 
	{
		@Autowired
		private CardExpiryRepository repository;
		
		@GetMapping("/readAll")
		public Iterable<CardExpiry> readAll()
		{
			Iterable<CardExpiry> all=repository.findAll();
			return all;
		}

	}

	

