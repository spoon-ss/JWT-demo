package com.demo.login.entity.dao;

import com.demo.login.entity.User;
import org.springframework.data.repository.CrudRepository;



public interface UserRepository extends CrudRepository<User, Long> {
}
