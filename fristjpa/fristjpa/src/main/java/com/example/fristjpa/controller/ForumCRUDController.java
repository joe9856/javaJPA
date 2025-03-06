package com.example.fristjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fristjpa.model.Forum;
import com.example.fristjpa.model.ForumInterfaceRepo;


@RestController  // เพิ่ม @RestController
public class ForumCRUDController {
/*
 ForumCRUDController (ทำงานกับ ForumInterfaceRepo)
📌 หน้าที่: ใช้ CrudRepository ใน Spring Data JPA

ใช้ repo.findAll() → ดึงข้อมูลทั้งหมดโดยไม่ต้องเขียน Query เอง
ใช้ Spring Data JPA ทำให้จัดการข้อมูลง่ายขึ้น
 */
    @Autowired
    ForumInterfaceRepo repo;

    @GetMapping("/ss")
    public Iterable<Forum> showAllForum() {
        Iterable<Forum> c = repo.findAll();  // ดึงข้อมูลฟอรัมทั้งหมด
        return c;  // คืนค่าฟอรัมทั้งหมด
    }
}
