package com.example.reverse_a_String.repository;
import com.example.reverse_a_String.model.*;
import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.stereotype.Repository;


@Repository
public class isPrimeRepository 
{
	private static final String URL = "jdbc:mysql://localhost:3306/DoubtsApp";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Tsat@9392350848";
    
    public void save(long num,boolean a)
    {
    	String query = "Insert into Isprime (num,output) Values (?,?)"; 
    	try( Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
    			PreparedStatement ps = conn.prepareStatement(query))                
    			{
    				ps.setLong(1,num);
    				ps.setBoolean(2,a);
    				ps.executeUpdate();
    			}
    	catch (SQLException e) 
    	{
            e.printStackTrace();
    	}
       
    }
    
    public List<isPrimeModel> get()
    {
    	List<isPrimeModel> result = new ArrayList<>();
    	String query = "Select * from Isprime";
    	try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
    			PreparedStatement ps = conn.prepareStatement(query);
    			ResultSet rs = ps.executeQuery())
    	{
    		while(rs.next())
    		{
    			isPrimeModel pm = new isPrimeModel();
    			pm.setId(rs.getLong("id"));
    			pm.setInput(rs.getLong("num"));
    			pm.setOutput(rs.getBoolean("output"));
    			result.add(pm);
    		}
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    	
    	return result;
    }
    
    
    
    public void update(long id,long num,boolean a)
    {
    	String query = "UPDATE Isprime SET num = ?, output = ? Where id = ?";
    	try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
    			PreparedStatement ps = conn.prepareStatement(query))
    			{
    				ps.setLong(1,num);
    				ps.setBoolean(2,a);
    				ps.setLong(3,id);
    				ps.executeUpdate();
    			}
    	catch (SQLException e) 
    	{
            e.printStackTrace();
    	}
    }
    
    
    
    public String delete(long id)
    {
    	String query = "Delete from Isprime where id = ?";
    	try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
    			PreparedStatement ps = conn.prepareStatement(query))
    	{
    		ps.setLong(1, id);
    		ps.executeUpdate();
    	}
    catch(SQLException e)
    	{
    	e.printStackTrace();
    	}
    	
    	return "Successfully deleted";
    }
    
    
    
    
}