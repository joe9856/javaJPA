package com.example.fristjpa.model;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class CustomerRepository {
	
	@PersistenceContext  //คือการทำ dependentsy  
	private EntityManager em; // ใช้เรียกเมธอดจัดการฐานข้อมูล ที่สร้างมาให้แล้ว
	
	public List<Customer> showAllCustomer() {
		Query rs = em.createQuery("from Customer");//ตั้งตาม JavaBeans // สร้างคำสั่ง SELECT ข้อมูลจากตาราง customer
		return rs.getResultList(); // ดึงรายการผลลัพธ์จากการ Query ส่งกลับ
		
	}
	
	public Customer findById(Integer id) {
		return em.find(Customer.class, id); // ค้นหา Customer ตาม id
	}
	
	@Transactional
	public Customer save(Customer cus) { //รับค่ามาจาก javabeans ตัวแปรชื่อ cus
		em.persist(cus);// insert กรณีไม่มีค่า id ใน object หรือ update กรณีมีค่า id ใน object
		return cus;
		
	}
	
	@Transactional
	public void delete(Integer id) {
		Customer customer = em.find(Customer.class, id); // ค้นหาตาม id ที่ต้องการลบ
		em.remove(customer); // เริ่มลบจริง
	}

}
