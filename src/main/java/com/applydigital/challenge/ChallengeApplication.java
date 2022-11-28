package com.applydigital.challenge;

import com.applydigital.challenge.entity.RoleEntity;
import com.applydigital.challenge.entity.UserEntity;
import com.applydigital.challenge.service.RoleService;
import com.applydigital.challenge.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
public class ChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeApplication.class, args);
	}


	/**
	 * Script for creation of dummy users, in order to test the JWT integration
	 *
	 */
	@Bean
	CommandLineRunner run(UserService userService, RoleService roleService){
		return args -> {
			roleService.saveRole(RoleEntity.builder().rolename("ROLE_ADMIN").build());
			roleService.saveRole(RoleEntity.builder().rolename("ROLE_JOURNALIST").build());

			userService.saveUser(UserEntity.builder().username("ckent").password("superman").build());
			userService.saveUser(UserEntity.builder().username("bwayne").password("batman").build());

			userService.addRoleToUser("ckent", "ROLE_JOURNALIST");
			userService.addRoleToUser("bwayne", "ROLE_ADMIN");
		};
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
