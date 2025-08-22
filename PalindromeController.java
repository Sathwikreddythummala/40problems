package com.example.reverse_a_String.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.reverse_a_String.model.palindromemodal;
import com.example.reverse_a_String.repository.palindromerepository;
import com.example.reverse_a_String.service.PalindromeService;


@RestController
public class PalindromeController 
{
	@Autowired
	private PalindromeService ps;
	
	@Autowired palindromerepository pr;
	
	@PostMapping("/palindrome")
	public String postPalindrome(@RequestBody Map<String,String> request)
	{
		String input = request.get("input");
		return ps.isPalindrome(input);
	}
	
	@GetMapping("/palindrome")
	public List<palindromemodal> getPalindrome()
	{
		return pr.get();
	}
	
	@PutMapping("/palindrome")
	public void putPalindrome(@RequestBody Map<String,Object> request)
	{
		Long id = Long.valueOf(request.get("id").toString());
		 String input = request.get("input").toString();
		ps.update(id, input);
	}
	
	@DeleteMapping("/palindrome")
	public void DeletePalindrome(@RequestBody Map<String,Long> request)
	{
		Long id = request.get("id");
		pr.delete(id);
	}
	
	
	
}
