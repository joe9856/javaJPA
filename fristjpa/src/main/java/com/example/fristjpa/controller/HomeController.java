package com.example.fristjpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/sec1") // กำหนด path
public class HomeController {
	
	@GetMapping("/student")
	public String สวัสดี(@RequestParam("fname") String n ,Model model) { // RequestParam เราต้องแนบข้อมูลมา
		
		model.addAttribute("name",n);
		
		return "home";
	}
	
	@GetMapping("/student/{id}/{fullname}")
	public String ข้อมูลจากพาธ(@PathVariable("id") String cid,@PathVariable("fullname") String fn,Model model) {
//		debug
		System.out.println(fn);
		System.out.println(cid);
		
		model.addAttribute("realid",cid);
		model.addAttribute("realname",fn);
		return "home";
	}
}
