package com.example.Javaclass.service.serviceImpl;

import com.example.Javaclass.model.Stack;
import com.example.Javaclass.repositories.StackRepositories;
import com.example.Javaclass.service.StackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StackServiceImpl implements StackService {
    private StackRepositories stackRepositories;

    @Autowired
    public StackServiceImpl(StackRepositories stackRepositories) {
        this.stackRepositories = stackRepositories;
    }



    @Override
    public Stack findStack(String name) {

        return stackRepositories.findByName(name);
    }

    @Override
    public void save(Stack stack) {
        stackRepositories.save(stack);
    }
}
