package com.example.fristjpa.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.fristjpa.model.Customer;
import com.example.fristjpa.model.CustomerList;
import com.example.fristjpa.model.ErrorDetail;
import com.example.fristjpa.model.Forum;
import com.example.fristjpa.model.ForumList;
import com.example.fristjpa.model.ForumRepository;

@RestController
@RequestMapping("/forum2")
public class ForumAPIController {
	
	
    @Autowired
    ForumRepository repo;  // กำหนด Repository

    @GetMapping("")
    public ForumList showAllForum() {  
    	List<Forum> frm  = (List<Forum>) repo.showAllForum();
        return new ForumList(frm);  
    }
    
    @PostMapping("") 
    public String addForum(@RequestBody Forum f) { 
    	
    	System.out.println(f.getLove());
		repo.save(f);
		return "Add forum successfull";
    }
    
    @GetMapping("/forum/{fid}")
	public ResponseEntity<?> ShowForum(@PathVariable("fid") Long fID) {
		
		Optional<Forum> x = repo.findById(fID);
		if(x.isPresent()) {
			return new ResponseEntity<>(x,HttpStatus.OK) ;//create opject return
		}
		else {
			ErrorDetail error = new ErrorDetail();
			error.setCode(999);
			error.setCode(HttpStatus.NOT_FOUND.value());
			error.setMsg("Not found ID: "+fID);
			return new ResponseEntity<>(error,HttpStatus.NOT_FOUND) ;
		}
	}
    
    @DeleteMapping("/forum/{fid}")
    public ResponseEntity<?> deleteForum(@PathVariable("fid") Long fID) {
        boolean deleted = repo.deleteById(fID);
        
        if (deleted) {
            return new ResponseEntity<>("ลบข้อมูลสำเร็จ", HttpStatus.OK);
        } else {
            ErrorDetail error = new ErrorDetail();
            error.setCode(HttpStatus.NOT_FOUND.value());
            error.setMsg("ไม่พบข้อมูล ID: " + fID);
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/forum/{fid}/love")
    public ResponseEntity<?> incrementLove(@PathVariable("fid") Long fID) {
        Forum updatedForum = repo.incrementLove(fID);
        if (updatedForum != null) {
            return new ResponseEntity<>(updatedForum, HttpStatus.OK);
        } else {
            ErrorDetail error = new ErrorDetail();
            error.setCode(HttpStatus.NOT_FOUND.value());
            error.setMsg("ไม่พบข้อมูล ID: " + fID);
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }


}
