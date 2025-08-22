package com.example.reverse_a_String.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.reverse_a_String.model.isPrimeModel;
import com.example.reverse_a_String.repository.isPrimeRepository;
import com.example.reverse_a_String.service.isPrimeService;

import jakarta.persistence.EntityManager;

@RestController
public class isPrimeController 
{
	@Autowired
	private isPrimeService ps;
	
	
	@Autowired 
	private isPrimeRepository pr;
	
	@PostMapping("/isPrime")
	public boolean postprime(@RequestBody Map<String,Long> request)
	{
		Long n = request.get("input");
		return ps.isPrime(n);
	}
	
	@GetMapping("isPrime")
	public List<isPrimeModel> getprime()
	{
		return pr.get();
	}
	
	
	@PutMapping("/isPrime")
	public void putprime(@RequestBody Map<String,Long> request)
	{
		Long id = request.get("id");
		Long num = request.get("input");
		ps.update(id,num);
	}
	
	@DeleteMapping("/isPrime")
	public String Deleteprime(@RequestBody Map<String,Long> request)
	{
		Long id = request.get("id");
		if(id==null) {return "Please give a id";}
		ps.Delete(id);
		return "Successfully Updated";
	}
}
