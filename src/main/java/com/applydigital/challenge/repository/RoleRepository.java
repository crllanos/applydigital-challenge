package com.applydigital.challenge.repository;

import com.applydigital.challenge.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    RoleEntity findByRolename(String rolename);

}
