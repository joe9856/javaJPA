package com.example.fristjpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.fristjpa.model.Student;


@Controller
@RequestMapping("dev")
public class StudentController {
	
//	http://localhost:224/dev/calYear?studentName=joe&yearOfBirth=2547
	
	@GetMapping("/calYear")
	public String showStudent(@ModelAttribute Student stu,Model model ) {
		
		//การกำหนดค่าเอาไว้	
//		model.addAttribute("name","joe");
//		model.addAttribute("year","2547");
		
//		model.addAttribute("abc",stu); //ค่าเก็บไว้ใน stu ส่งค่าไปด้วย abc
/*
 เมื่อส่งแล้วได้ก้อน object Hello com.example.fristjpa.model.Student@fac69fc
Your age is com.example.fristjpa.model.Student@fac69fc

ต้องใส่ .get ด้วยที่หน้า jsp
 */		
		int age = 2568-stu.getYearOfBirth();
		
		model.addAttribute("name",stu.getStudentName()); //ค่าเก็บไว้ใน stu ส่งค่าไปด้วย abc
		model.addAttribute("age",age);
		return "student";
	}
}
