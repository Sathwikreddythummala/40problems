package com.example.reverse_a_String.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Isprime")
public class isPrimeModel 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private long num;
	private boolean output;
	
	public void setInput(long num)
	{
		this.num=num;
	}
	
	public void setOutput(boolean output)
	{
		this.output=output;
	}
	
	public long getInput()
	{
		return num;
	}
	
	public boolean getOutput()
	{
		return output;
	}

	public void setId(long id) 
	{
		this.id=id;
	}
	
	public long getId()
	{
		return id;
	}
}
