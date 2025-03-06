package com.example.fristjpa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.fristjpa.model.Customer;
import com.example.fristjpa.model.CustomerInterfaceRepo;

@Controller
@RequestMapping("/cus")
public class CustomerMVCController {
	
//	connect sql
	@Autowired
	CustomerInterfaceRepo repo;
	
	@GetMapping("/show/{cid}") //cus/show/1
	public String แสดงข้อมูลตามไอดี(@PathVariable("cid") Integer cusid ,Model m) {
		
//		searth
		Optional<Customer> x = repo.findById(cusid); //บังคับให้เป็น optional อยากรู้ให้เอาเมาส์ไปวางไว้ตรง findById ว่า มันต้องการอะไร  

//		debug เช็คว่ามันมีไหม
		System.out.println(x.get().getId()*100);
		System.out.println(x.get().getFirstName());
		
//		send page view
		
		m.addAttribute("xyz",x.get().getId()*100); // .get() คือการดชเอาค่ามันมา
		m.addAttribute("abc",x.get().getFirstName()); //ค่าเก็บไว้ใน stu ส่งค่าไปด้วย abc

		
		
		return "show-customer";
	}
}
