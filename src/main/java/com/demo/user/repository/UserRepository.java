package com.demo.user.repository;

import com.demo.user.entity.UserEntity;
import org.springframework.data.repository.Repository;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Optional;


public interface UserRepository extends Repository<UserEntity, Integer> {

    @Nullable
    UserEntity save(UserEntity entity);
    @Nullable
    Optional<UserEntity> findById(Integer id);
    @Nullable
    Optional<UserEntity>  findByUsername(String username);

    boolean existsById(Integer id);

    @NonNull
    Iterable<UserEntity> findAll();


}
