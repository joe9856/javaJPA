package com.example.fristjpa.model;

import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface CustomerInterfaceRepo extends CrudRepository<Customer, Integer> {
	
	List<Customer> findByFirstNameContaining(String firstName);
	
//	select * from customer where firstName Like %J%
}
