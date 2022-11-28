package com.applydigital.challenge.service;

import com.applydigital.challenge.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserEntity saveUser(UserEntity user);
    UserEntity findUser(String username);
    void addRoleToUser(String username, String rolename);

}
