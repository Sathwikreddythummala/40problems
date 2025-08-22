package com.example.reverse_a_String.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "palindrometable")


public class palindromemodal 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String Input;
	
	@Column(nullable = false)
	private String Output;
	
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public void setInput(String Input)
	{
		this.Input = Input;
	}
	
	public void setOutput(String Output)
	{
		this.Output = Output;
	}
	
	public String getInput()
	{
		return Input;
	}
	
	public String getOutput()
	{
		return Output;
	}
	
	public Long getId()
	{
		return id;
	}
}
