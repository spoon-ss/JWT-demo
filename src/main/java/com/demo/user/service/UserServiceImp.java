package com.demo.user.service;

import com.demo.user.entity.UserEntity;
import com.demo.user.exception.NoUserFoundException;
import com.demo.user.exception.UserWithSameUsernameException;
import com.demo.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getUsers(){
        List<UserEntity> userList = new ArrayList<UserEntity>();
        for(UserEntity user : userRepository.findAll()){
            userList.add(user);
        }
        return userList;
    }

    public UserEntity getUserById(int id){
        Optional<UserEntity> ans = userRepository.findById(id);
        if(ans.isPresent()){
            return ans.get();
        }
        return null;
    }

    public void updateUserPassword(int id, String newPassword){
        Optional<UserEntity> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new NoUserFoundException("cannot find such a user.");
        }
        UserEntity userEntity = user.get();
        userEntity.setPassword(newPassword);
        userRepository.save(userEntity);
    }

    public void addNewUser(String username, String password, String email){
        Optional<UserEntity> user = userRepository.findByUsername(username);
        if(user.isPresent()){
            throw new UserWithSameUsernameException("find another user with same username.");
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        userEntity.setEmail(email);
        userEntity.enable();

        userRepository.save(userEntity);
    }
}
