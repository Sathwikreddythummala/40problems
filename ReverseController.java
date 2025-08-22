package com.example.reverse_a_String.controller;
import java.util.*;

import com.example.reverse_a_String.model.Reverse;
import com.example.reverse_a_String.repository.ReverseRepository;
import com.example.reverse_a_String.service.ReverseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class ReverseController 
{

@Autowired
private ReverseRepository rr;

@Autowired
private ReverseService rs;
	
	
@GetMapping("/reverse")
public List<Reverse> getAll()
{
	return rr.get();
}
	
 
 @PostMapping("/reverse")
 public String reverse(@RequestBody Map<String,String> request)
 {
	 String sb = request.get("input");
	 return rs.reverseandsave(sb);
 }
 
 @PutMapping("/reverse")
 public String onEdit(@RequestBody Map<String,Object> request)
 {
	 Long id = Long.valueOf(request.get("id").toString());
	 String input = request.get("input").toString();
	 return rs.edit(id, input);
 }
 
 
 
 
 @DeleteMapping("/reverse")
 public String Delete(@RequestBody Map<String,Long> request)
 {
	 Long id = request.get("id");
	 return rs.Delete(id);
 }   
}