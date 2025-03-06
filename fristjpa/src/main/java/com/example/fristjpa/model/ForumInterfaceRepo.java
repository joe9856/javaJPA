package com.example.fristjpa.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Date;



public interface ForumInterfaceRepo extends CrudRepository<Forum, Long> {
    List<Forum> findByLoveEquals(Integer love);  // ค้นหาโพสต์ที่มีจำนวน love เท่ากับค่าที่กำหนด
}


/*
ใช้ Spring Data JPA ทำให้ไม่ต้องเขียน SQL เอง
ใช้ findByLoveEquals() เพื่อค้นหาโพสต์ที่มีจำนวนไลก์เท่ากับค่าที่กำหนด


สรุปการทำงานของโปรเจกต์
Forum (Model Layer) → เป็น Entity ที่แทนตาราง forum
ForumInterfaceRepo (ใช้ CrudRepository) → ใช้งานง่าย ใช้สำหรับ CRUD ทั่วไป
ForumRepository (ใช้ EntityManager) → กำหนด Query เองได้อิสระ
ForumController → ให้ API Endpoint ทำงานกับ ForumRepository
ForumCRUDController → ใช้ CrudRepository ดึงข้อมูลทั้งหมด
🔹 ใช้ ForumInterfaceRepo ถ้าต้องการความสะดวก (CRUD ธรรมดา)
🔹 ใช้ ForumRepository ถ้าต้องการควบคุม SQL Query โดยตรง
  */
