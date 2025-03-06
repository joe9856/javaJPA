package com.example.fristjpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fristjpa.model.Customer;
import com.example.fristjpa.model.CustomerInterfaceRepo;
import com.example.fristjpa.model.CustomerList;
import com.example.fristjpa.model.ErrorDetail;

@RestController
//@Controller ต้องมี view
@RequestMapping("/api/v1")
public class CustomerAPIController {
	
// ต้องฉีด ependency repo ที่เราทำ
		
	@Autowired
	CustomerInterfaceRepo repo;
	
	@GetMapping("/customers")
	public CustomerList แสดงข้อมูล() {
//		Iterable<Customer> cus = repo.findAll();		
		List<Customer> cus  = (List<Customer>) repo.findAll();
		
		
		return new CustomerList(cus);
	}
	
	@PostMapping("/customers")
	public String addCustomer(@RequestBody Customer c) {
		
		System.out.println(c.getFirstName());
		// method ที่เอาไว้ลงฐานข้อมูล save ที่เราทำไว้
		repo.save(c);
		return "Add customer successfull";
		
	}
	
	@GetMapping("/customers/{cid}")
	public ResponseEntity<?> ShowCustomer(@PathVariable("cid") Integer cusID) {
		
//		ข้อมูลอยู่ใน x อยู๋แล้ว	
		
//		debug
//		System.out.println("cusID"+cusID);
	
		Optional<Customer> x = repo.findById(cusID); //ถ้าจะส่งข้อมูลกลับต้องส่งกลับโดย Optional<javabeans> //รับเป็น interger เลยไม่ต้องแปลง
		if(x.isPresent()) {
			return new ResponseEntity<>(x,HttpStatus.OK) ;//create opject return
		}
		else {
			ErrorDetail error = new ErrorDetail();
			error.setCode(999);
			error.setCode(HttpStatus.NOT_FOUND.value());
			error.setMsg("Not found ID: "+cusID);
			return new ResponseEntity<>(error,HttpStatus.NOT_FOUND) ;
		}
	}
}


