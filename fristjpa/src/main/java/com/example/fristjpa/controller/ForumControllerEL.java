package com.example.fristjpa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.fristjpa.model.Forum;
import com.example.fristjpa.model.ForumRepository;


@Controller
public class ForumControllerEL {

    @Autowired
    private ForumRepository forumRepository; // สร้างตัวแปรเพื่อเรียกใช้งาน Repository

    @GetMapping("/forumshowEL")
    public String showAllForums(Model model) {
        // ดึงข้อมูลทั้งหมดจาก ForumRepository
        List<Forum> flist = forumRepository.showAllForum();
       
        model.addAttribute("allForums", flist);
        
        return "showforum";  
    }
}

