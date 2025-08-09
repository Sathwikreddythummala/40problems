package com.example.reverse_a_String.controller;
import java.util.*;

import com.example.reverse_a_String.model.Reverse;
import com.example.reverse_a_String.repository.ReverseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReverseController 
{

	@Autowired
	private ReverseRepository rr;
	
 
 @PostMapping("/reverse")
 public String reverse(@RequestParam String input)
 {
	 String sb = new StringBuilder(input).reverse().toString();
	 System.out.println(sb);
	 
	 Reverse r = new Reverse();
	 r.setInput(input);
	 r.setOutput(sb);
	 
	 rr.save(r);
	 //System.out.println(sb);
	 
	 return sb;
 }
       
}