package com.example.reverse_a_String.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.reverse_a_String.model.Reverse;

@Repository
public interface ReverseRepository extends JpaRepository<Reverse, Long> 
{
    
    
    
}