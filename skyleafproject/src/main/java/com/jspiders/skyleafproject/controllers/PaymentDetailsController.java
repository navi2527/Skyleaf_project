package com.jspiders.skyleafproject.controllers;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.jspiders.skyleafproject.beans.BillingDetails;
import com.jspiders.skyleafproject.beans.Card;
import com.jspiders.skyleafproject.beans.CardExpiry;
import com.jspiders.skyleafproject.beans.PaymentDetails;
import com.jspiders.skyleafproject.beans.returnlinks;
import com.jspiders.skyleafproject.repository.BillingDetailsRepository;
import com.jspiders.skyleafproject.repository.CardExpiryRepository;
import com.jspiders.skyleafproject.repository.CardRepository;
import com.jspiders.skyleafproject.repository.PaymentDetailsRepository;
import com.jspiders.skyleafproject.repository.ReturnLinksRepository;

/*@RestController
@RequestMapping("/paymentdetails")

public class PaymentDetailsController 
{
	
	@Autowired
	PaymentDetailsRepository repository;
	
	@GetMapping("/readAll")
    public Iterable<PaymentDetails> readAll()
    {
		Iterable<PaymentDetails> readall = repository.findAll();
		
		return readall;
    }	 
}*/

@RestController
@RequestMapping("/paymentdetails")
public class PaymentDetailsController 
{
	
	@Autowired
	private PaymentDetailsRepository payrepository;
	@Autowired
	private BillingDetailsRepository billrepository;
	@Autowired
	private CardRepository cardrepository;
	@Autowired
	private CardExpiryRepository cardexpirerepository;
	@Autowired
	private ReturnLinksRepository linksrepository;
	
	@GetMapping("/readAll")
	public String readAll()
	{	
		//payment
		Iterable<PaymentDetails> all = payrepository.findAll();
		Gson gson = new Gson();
		String json = gson.toJson(all);
		JSONArray j1 = new JSONArray(json);
		JSONObject res = new JSONObject(j1.get(0).toString());
		
		//billing
		Iterable<BillingDetails> billresponse = billrepository.findAll();
		json = gson.toJson(billresponse);
		JSONObject billingJson = new JSONObject(new JSONArray(json).get(0).toString());
		res.put("BillingDetails", billingJson);
		
		//card
		Iterable<Card> cardresponse = cardrepository.findAll();
		json = gson.toJson(cardresponse);
		JSONObject cardJson = new JSONObject(new JSONArray(json).get(0).toString());
		res.put("Card", cardJson);
		
		//cardExpire
		Iterable<CardExpiry> cardexpire = cardexpirerepository.findAll();
		json = gson.toJson(cardexpire);
		JSONObject cardexpiryJson = new JSONObject(new JSONArray(json).get(0).toString());
		cardJson.put("caredExpiry", cardexpiryJson);
		
		//returns link
		Iterable<returnlinks> returnlinkers = linksrepository.findAll();
		json = gson.toJson(returnlinkers);
		//JSONObject returnlinkJson = new JSONObject(new JSONArray(json).get(0).toString());
		cardJson.put("returnlinkres", new JSONArray(json));
		res.put("returnlinkerres", returnlinkers);
		
		return res.toString();	
	}
}
