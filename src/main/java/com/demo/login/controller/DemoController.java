package com.demo.login.controller;

import com.demo.login.entity.User;
import com.demo.login.entity.service.UserServiceImp;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class DemoController {

    @Autowired
    UserServiceImp userServiceImp;

    @GetMapping("/user")
    public List<User> getUsers(){

        return userServiceImp.getUsers();
    }

    @PostMapping("/user")
    public void addUser(@RequestBody User user){
        userServiceImp.addNewUser(user);
    }
}
