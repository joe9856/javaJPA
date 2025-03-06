package com.example.fristjpa.model;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class ForumRepository {

	/*
	 * ForumRepository (ใช้ EntityManager จัดการโดยตรง)
📌 หน้าที่: ใช้ EntityManager สำหรับ Query, Insert, Update, Delete ข้อมูล
	 */
    @PersistenceContext  
    private EntityManager em;

    public List<Forum> showAllForum() {
        Query rs = em.createQuery("from Forum"); // ดึงข้อมูลฟอรัมทั้งหมด
        return rs.getResultList();  // คืนค่าผลลัพธ์ทั้งหมดเป็น List
    }

    @Transactional
    public Forum save(Forum frm) {  // บันทึกฟอรัมใหม่
        em.persist(frm);
        return frm;
    }
    
 // ✅ เพิ่มเมทอดค้นหา Forum ตาม id
    public Optional<Forum> findById(Long id) {
        Forum forum = em.find(Forum.class, id);
        return Optional.ofNullable(forum);
    }

    
    @Transactional
    public Forum update(Forum forum) {
        Forum existingForum = em.find(Forum.class, forum.getId()); // ค้นหาข้อมูลเดิม
        if (existingForum != null) {
        	
            existingForum.setDetail(forum.getDetail());
            existingForum.setAuthor(forum.getAuthor());
            existingForum.setLove(forum.getLove());
            existingForum.setPost_date(forum.getPost_date());
            em.flush(); // บันทึกการเปลี่ยนแปลง
        }
        return existingForum;
    }
    
    @Transactional
    public Forum incrementLove(Long id) {
        Forum forum = em.find(Forum.class, id); // ค้นหาฟอรัมที่ต้องการ
        if (forum != null) {
            forum.setLove(forum.getLove() + 1); // เพิ่มค่า love
            em.flush(); // บันทึกการเปลี่ยนแปลง
        }
        return forum; // คืนค่า forum ที่ถูกอัพเดต
    }
    
    @Transactional
    public boolean deleteById(Long id) {
        Forum forum = em.find(Forum.class, id);
        if (forum != null) {
            em.remove(forum);
            return true; // ลบสำเร็จ
        }
        return false; // ไม่พบข้อมูลที่ต้องการลบ
    }
}

/*
 ใช้ EntityManager ทำ Query แทน CrudRepository
@Transactional ใช้เมื่อมีการบันทึกหรืออัปเดตข้อมูล
findById() ใช้ Optional<Forum> เพื่อป้องกัน Null Pointer
 **/
