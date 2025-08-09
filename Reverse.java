package com.example.reverse_a_String.model;

import jakarta.persistence.*;


@Entity
@Table(name = "reverse_records")
public class Reverse {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String input;
    
    @Column(nullable = false)
    private String output;
    
    
    public Long getId() 
    {
        return id;
    }
    
    public void setInput(String input)
    {
    	this.input = input;
    }
    
    public String getInput()
    {
    	return input;
    }
    
    public void setOutput(String output)
    {
    	this.output = output;
    }
    
    public String getOutput()
    {
    	return output;
    }
    
}