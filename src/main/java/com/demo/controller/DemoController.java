package com.demo.controller;

import com.demo.user.entity.UserEntity;
import com.demo.user.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class DemoController {

    @Autowired
    UserServiceImp userServiceImp;

    @GetMapping("/user")
    public List<UserEntity> getUsers(){

        return userServiceImp.getUsers();
    }


}
