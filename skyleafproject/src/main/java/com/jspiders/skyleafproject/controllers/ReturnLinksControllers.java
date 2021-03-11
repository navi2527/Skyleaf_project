package com.jspiders.skyleafproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.jspiders.skyleafproject.beans.returnlinks;
import com.jspiders.skyleafproject.repository.ReturnLinksRepository;


@RestController
@RequestMapping("/returnlinks")
public class ReturnLinksControllers
{
	
		@Autowired
		private ReturnLinksRepository repository;
		
		@GetMapping("/readAll")
		public Iterable<returnlinks> readAll()
		{
			Iterable<returnlinks> all=repository.findAll();
			return all;
		}
	

}
