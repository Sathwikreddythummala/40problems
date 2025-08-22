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

import com.example.reverse_a_String.model.Reverse;

@Repository
public class ReverseRepository
{
	private static final String URL = "jdbc:mysql://localhost:3306/DoubtsApp";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Tsat@9392350848";
	
    public void save(String input,String output)
    {
    	String query = "Insert into reverse_records (input,output) Values (?,?)";
    	try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
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
    	String query = "update reverse_records set input = ? , output = ? where id = ?";
    	try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
    			PreparedStatement ps = conn.prepareStatement(query))
    	{
    		ps.setString(1,input);
    		ps.setString(2,output);
    		ps.setLong(3,id);
    		ps.executeUpdate(); //
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public String delete(Long id)
    {
    	String query = "Delete from reverse_records where id = ?";
    	
    	try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
    			PreparedStatement ps = conn.prepareStatement(query))
    	{
    		ps.setLong(1,id);
    		ps.executeUpdate();
    	}
    	catch( SQLException e)
    	{
    		e.printStackTrace();
    	}
		return "";
    	
    }
    
    public List<Reverse> get()
    {
    	String query = "select * from reverse_records";
    	List<Reverse> l = new ArrayList<>();
    	try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
    			PreparedStatement ps = conn.prepareStatement(query);
    					ResultSet r = ps.executeQuery())
    	{
    		while(r.next())
    		{
    			Reverse rs = new Reverse();
    			rs.setId(r.getLong("id"));
    			rs.setInput(r.getString("input"));
    			rs.setOutput(r.getString("output"));
    			l.add(rs);
    					
    		}
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    	
    	return l;
    }
}


