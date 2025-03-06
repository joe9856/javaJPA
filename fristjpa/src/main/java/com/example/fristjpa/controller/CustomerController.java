package com.example.fristjpa.controller;

import java.security.PublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fristjpa.model.Customer;
import com.example.fristjpa.model.CustomerRepository;

@RestController
public class CustomerController {
//	เอา DAO มาใช้ เอาคลาสที่เป็น Repository
	
	@Autowired 	//จะฉีด setter ให้อัตรโนมัติ ถ้ามันมีอะไรเดี๋ยวทำให้ 
	CustomerRepository repo; //get All method in CustomerRepository
	
	@GetMapping("/show")
	public String showAll() {

		List<Customer> customerList =  repo.showAllCustomer(); //เอามาแล้วเก็บข้อมูลไว้ในนี้
//		เอามาแสดงวนลูป
		for(Customer c:customerList) { // วนออกมาทุกตัว
			System.out.println(c.getId()+"  "+c.getFirstName());
		}
		return null;
	}
	
	@GetMapping("/save")
	public String add() {
		Customer cus1 = new Customer();
//		ไม่ต้องใช้ ID พราะเป็น Auto
		cus1.setFirstName("Joe"); //ยังไม่ได้เอาตัวแปรไปใส่ในคลาส
		repo.save(cus1);
		return "Add customerSuccessFull";
	}
	
}
