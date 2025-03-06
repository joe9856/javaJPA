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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.fristjpa.model.Forum;
import com.example.fristjpa.model.ForumRepository;

@Controller // ใช้ @Controller แทน @RestController เพื่อรองรับ JSP
@RequestMapping("/forum1")
public class ForumController {
	
	/*
	 ForumController (ทำงานกับ ForumRepository)
📌 หน้าที่: ให้ API Endpoint สำหรับ ดึง, เพิ่ม, อัปเดต ข้อมูล
	 */
    @Autowired
    ForumRepository repo;  // กำหนด Repository

    @GetMapping("/forum/show")
    public List<Forum> showAll() {  // คืนค่าลิสต์ของฟอรัม
        List<Forum> forumList = repo.showAllForum();
        return forumList;  // คืนค่าฟอรัมทั้งหมดในรูปแบบ JSON
    }

    @GetMapping("/forum/save")  
    public String addForum() {
        Date d = new Date();
        Forum frm = new Forum();
        frm.setDetail("loginlogin");
        frm.setAuthor("joe615611");
        frm.setLove(1000000);
        frm.setPost_date(d);
        repo.save(frm);
        return "Add Forum Success";  
    }
    
//    @GetMapping("/update/{id}") // ใช้ GET แทน PUT
//    public ResponseEntity<String> updateLove(@PathVariable Long id) {
//        int newLove = 1000000; // ค่าที่ต้องการอัปเดต
//
//        Optional<Forum> loveEntityOpt = repo.findById(id);
//
//        if (loveEntityOpt.isPresent()) {
//            Forum loveEntity = loveEntityOpt.get();
//            loveEntity.setLove(newLove);  
//            repo.save(loveEntity); 
//            return ResponseEntity.ok("Updated Love to " + newLove + " for ID: " + id);
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Love entity not found for ID: " + id);
//        }
//    }
    
    @GetMapping("/update/{id}")
    public ResponseEntity<String> updateLove(@PathVariable Long id) {
        Forum existingForum = repo.findById(id).orElse(null);
        if (existingForum != null) {
            existingForum.setLove(90000000);  // อัปเดตค่า Love
            repo.update(existingForum); // บันทึกการเปลี่ยนแปลง
            return ResponseEntity.ok("Updated Love for ID: " + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Forum not found for ID: " + id);
        }
    }
    
    @PostMapping("/save")
    public String addForum(@RequestParam String detail, @RequestParam String author) {
        Date d = new Date();
        Forum frm = new Forum();
        frm.setDetail(detail);
        frm.setAuthor(author);
        frm.setLove(0); // ค่าเริ่มต้นของ Love เป็น 0
        frm.setPost_date(d);
        repo.save(frm);
        return "redirect:/forum";
    }
    
    @PostMapping("/updateIDLove/{id}")
    @ResponseBody
    public ResponseEntity<Integer> updateLove1(@PathVariable Long id) {
        Optional<Forum> existingForumOpt = repo.findById(id);
        Forum forum = existingForumOpt.get();
        forum.setLove(forum.getLove() + 1);  // เพิ่มค่า Love
        repo.save(forum);
        return ResponseEntity.ok(forum.getLove());
    }

    @GetMapping("")
    public String showAllForums(Model model) {
        // ดึงข้อมูลทั้งหมดจากฐานข้อมูล
        List<Forum> forumList = repo.showAllForum();  // หรือใช้ repo.showAllForum() ตามที่คุณกำหนดไว้
        // สร้าง List เพื่อเก็บค่าที่ต้องการใช้
        List<String> formattedForums = new ArrayList<>();
        for (Forum forum : forumList) {
            System.out.println("ID: " + forum.getId());
            System.out.println("Author: " + forum.getAuthor());
            System.out.println("Detail: " + forum.getDetail());
            System.out.println("Love: " + forum.getLove());
            System.out.println("Post Date: " + forum.getPost_date());
        }

        // ส่งข้อมูลไปยัง view (show-forum)
        System.out.println("forums"+forumList);
        model.addAttribute("forums", forumList);

        return "show-forum";  // คืนค่าหน้า show-forum.jsp หรือ show-forum.html
    }
    
    @GetMapping("/incrementLove/{id}")
    public String incrementLove(@PathVariable Long id) {
    	repo.incrementLove(id);  // เรียกฟังก์ชันเพิ่มค่า Love
        return "redirect:/forum";  // รีไดเรกต์กลับไปที่หน้า show
    }

}
