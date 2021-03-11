package com.jspiders.skyleafproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jspiders.skyleafproject.beans.Card;
import com.jspiders.skyleafproject.repository.CardRepository;


@RestController
@RequestMapping("/card")

public class CardController
{
	@Autowired
	private CardRepository repository;
	
	@GetMapping("/readAll")
	public Iterable<Card> readAll()
	{
		Iterable<Card> readall =  repository.findAll();
		return readall;
	}
}
