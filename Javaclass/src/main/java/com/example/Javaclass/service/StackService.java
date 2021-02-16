package com.example.Javaclass.service;

import com.example.Javaclass.model.Stack;

public interface StackService {
    Stack findStack(String name);
    void save(Stack stack);
}
