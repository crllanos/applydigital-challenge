package com.applydigital.challenge.service.impl;

import com.applydigital.challenge.entity.RoleEntity;
import com.applydigital.challenge.entity.UserEntity;
import com.applydigital.challenge.repository.UserRepository;
import com.applydigital.challenge.service.RoleService;
import com.applydigital.challenge.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserEntity saveUser(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public UserEntity findUser(String username) {
        log.info("trying to find {}...", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        UserEntity user = this.findUser(username);
        RoleEntity role = roleService.findByRolename(rolename);
        user.getRoles().add(role);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = this.findUser(username);
        if(userEntity == null){
            throw new UsernameNotFoundException("Invalid credentials.");
        }

        Collection<SimpleGrantedAuthority> authRoles = new ArrayList<>();
        userEntity.getRoles().forEach(r -> {
            authRoles.add(new SimpleGrantedAuthority(r.getRolename()));
        });
        return new User(userEntity.getUsername(), userEntity.getPassword(), authRoles);

    }
}
