package com.example.reverse_a_String.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reverse_a_String.model.palindromemodal;
import com.example.reverse_a_String.repository.palindromerepository;


@Service
public class PalindromeService 
{
	
	
	
	@Autowired
	private palindromerepository pr;
	
	public String palincheck(String input)
	{
		String sb = new StringBuilder(input).reverse().toString();
		
		String result;
		if(input.equalsIgnoreCase(sb))
		{
			result="yes";
			
		}
		else
		{
			result="no";
			
		}
		return result;
	}
	
	public String isPalindrome(String input)
	{
		String result = palincheck(input);
		
		pr.save(input,result);
		return result;
	}
	
	public String update(Long id,String input)
	{
		String result = palincheck(input);
		pr.update(id,input,result);
		return result;
	}	
}
