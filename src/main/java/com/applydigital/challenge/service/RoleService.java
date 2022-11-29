package com.applydigital.challenge.service;

import com.applydigital.challenge.entity.RoleEntity;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {

    RoleEntity saveRole(RoleEntity role);
    RoleEntity findByRolename(String rolename);

}
