package com.example.fristjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fristjpa.model.Customer;
import com.example.fristjpa.model.CustomerInterfaceRepo;

@RestController
public class CustomerCRUDController {

	@Autowired //ผูก dependensy extention
	
	CustomerInterfaceRepo repo;
	
	@GetMapping("/s")
	public String showAllCustomer() {
		Iterable<Customer> c = repo.findAll();
		for(Customer x:c) {
			System.out.println(x.getFirstName()+"  "+x.getId());
		}
		return null;
	}
}
