package com.applydigital.challenge.service.impl;

import com.applydigital.challenge.entity.RoleEntity;
import com.applydigital.challenge.repository.RoleRepository;
import com.applydigital.challenge.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public RoleEntity saveRole(RoleEntity role) {
        return roleRepository.save(role);
    }

    @Override
    public RoleEntity findByRolename(String rolename) {
        return roleRepository.findByRolename(rolename);
    }


}
