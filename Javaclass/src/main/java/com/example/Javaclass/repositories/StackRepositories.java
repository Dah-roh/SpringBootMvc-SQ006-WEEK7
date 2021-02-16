package com.example.Javaclass.repositories;

import com.example.Javaclass.model.Stack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StackRepositories extends JpaRepository<Stack, Long> {
    
    Stack findByName(String name);

}
