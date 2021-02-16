package com.example.Javaclass.controller;

import com.example.Javaclass.model.Stack;
import com.example.Javaclass.repositories.StackRepositories;
import com.example.Javaclass.service.StackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StackController {

private StackService stackService;
private StackRepositories stackRepositories;


    @Autowired
    public StackController(StackService stackService, StackRepositories stackRepositories) {
        this.stackService = stackService;
        this.stackRepositories = stackRepositories;
    }

    @PostMapping("/saveStack")
    public String saveNewStack(@ModelAttribute("stack") Stack stack,  BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "/";
        }
        stackService.save(stack);
        return "redirect:/";
    }

    @GetMapping("/save")
    public String savePage(Stack stack, Model model){
        model.addAttribute("stack", stack);
        return "saveStack";
    }

    @GetMapping("/findStack")
    public String findStackInfo(@RequestParam(value = "name", required = false) String name, Model model){
        Stack stack = stackService.findStack(name);
        model.addAttribute("stacks", stack);
        return "stackDetails";
    }

    @GetMapping("/find")
    public String findStack(Model model){
        model.addAttribute("stack", new Stack());
        return "findStackInfo";
    }

//homePage
    @GetMapping("/")
    public String viewStack (@ModelAttribute("foundStack") Stack foundStack, Model model){
        List<Stack> stackList = stackRepositories.findAll();
        if (stackList.size()!=0){
            model.addAttribute("stacks", stackList.get(0));
            return "stackDetails";
        }
        Stack stack = new Stack();
        stack.setName("no name saved yet");
        stack.setSquad("no squad saved yet");
        model.addAttribute("stacks", stack);
        return "stackDetails";

    }
    }