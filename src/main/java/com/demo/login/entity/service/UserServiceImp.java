package com.demo.login.entity.service;

import com.demo.login.entity.User;
import com.demo.login.entity.dao.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers(){
        List<User> userList = new ArrayList<User>();
        for(User user : userRepository.findAll()){
            userList.add(user);
        }
        return userList;
    }

    public void addNewUser(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        String password = encoder.encode(user.getPassword());
        user.setPassword(password);
        userRepository.save(user);
    }
}
