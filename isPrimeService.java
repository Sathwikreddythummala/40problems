package com.example.reverse_a_String.service;

import java.math.BigInteger;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reverse_a_String.model.isPrimeModel;
import com.example.reverse_a_String.repository.isPrimeRepository;

import jakarta.persistence.EntityManager;

@Service
public class isPrimeService 
{
	@Autowired
	private isPrimeRepository pr;
	
	
	public Boolean PrimeCheck(long num)
	{
		
		BigInteger bigNum = BigInteger.valueOf(num);
		return bigNum.isProbablePrime(10);
		
		
		/*int f = 0;
		for(long i=2;i*i<=num;i++)
		{
			if(num%i==0)
			{
				f=1;
				break;
			}
		}
		
		if(f==1)
		{
			return false;
		}
		else
		{
			return true;
		}*/
	}
	
	public boolean isPrime(long n)
	{
		isPrimeModel pm = new isPrimeModel();
		boolean x = PrimeCheck(n);
		pm.setInput(n);
		pm.setOutput(x);
		pr.save(n,x);
		return PrimeCheck(n);
	}
	
	public String update(long id,long n)
	{
		isPrimeModel pm = new isPrimeModel();
		boolean x = PrimeCheck(n);
		pm.setInput(n);
		pm.setOutput(x);
		pr.update(id, n, x);
		return "Successfully updated";
	}
	
	public String Delete(long id)
	{
		pr.delete(id);
		return "Succesfully deleted";
	}
		
}


