package com.example.reverse_a_String.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.reverse_a_String.model.palindromemodal;

@Repository
public class palindromerepository
{
    private static final String URL = "jdbc:mysql://localhost:3306/DoubtsApp";
    private static final String USER = "root";
    private static final String PASSWORD = "Tsat@9392350848";
    
    public void save(String input,String output)
    {
    	String query = "Insert into palindrometable (input,output) Values (?,?)";
    	try(Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
    			PreparedStatement ps = conn.prepareStatement(query))
    	{
    		ps.setString(1,input);
    		ps.setString(2,output);
    		ps.executeUpdate();
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public void update(Long id,String input,String output)
    {
    	String query = "Update palindrometable set input = ?,output = ? where id = ?";
    	try(Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
    			PreparedStatement ps = conn.prepareStatement(query))
    	{
    		ps.setString(1,input);
    		ps.setString(2,output);
    		ps.setLong(3,id);
    		ps.executeUpdate();
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public void delete(Long id)
    {
    	String query = "Delete from palindrometable where id = ?";
    	try(Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
    			PreparedStatement ps = conn.prepareStatement(query))
    	{
    		ps.setLong(1,id);
    		ps.executeUpdate();
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public List<palindromemodal> get()
    {
    	List<palindromemodal> l = new ArrayList<>();
    	
    	String query = "Select * from palindrometable";
    	try(Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
    			PreparedStatement ps = conn.prepareStatement(query);
    			ResultSet rs = ps.executeQuery())
    	{
    		while(rs.next())
    		{
    			palindromemodal pm = new palindromemodal();
    			pm.setId(rs.getLong("id"));
    			pm.setInput(rs.getString("input"));
    			pm.setOutput(rs.getString("output"));
    			l.add(pm);
    		}
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    	
    	return l;
    	
    }
}