package com.example.fristjpa.model;

import java.util.List;

public class CustomerList {
//	ทำในรูปแบบ json ที่เก็บเป็นก้อนๆ 
	
	private List<Customer> customer;

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

	public CustomerList(List<Customer> customer) {
		super();
		this.customer = customer;
	}
	
	
	
	
}
