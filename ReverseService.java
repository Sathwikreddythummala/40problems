package com.example.reverse_a_String.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;



import com.example.reverse_a_String.model.Reverse;
import com.example.reverse_a_String.repository.ReverseRepository;

import jakarta.persistence.EntityManager;
import org.hibernate.Session; // ✅ Correct


@Service
public class ReverseService 
{
	
	@Autowired
    private EntityManager entityManager;
	
	@Autowired
	ReverseRepository rr;
	public String reverseandsave(String input)
	 {
		 String sb = new StringBuilder(input).reverse().toString(); 
		 rr.save(input,sb); 
		 return sb;
	 }
	
	
	
	
	public String edit(Long id, String input) {
	    String output = new StringBuilder(input).reverse().toString();
	    
	    rr.update(id,input,output);

	    return "updated Successfully";
	}
	
	public String Delete(Long id)
	{
		rr.delete(id);
		return "Successfully deleted";
	}
	
	

}
