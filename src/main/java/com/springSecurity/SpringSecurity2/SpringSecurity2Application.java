package com.springSecurity.SpringSecurity2;

import com.springSecurity.SpringSecurity2.models.ERole;
import com.springSecurity.SpringSecurity2.models.RoleEntity;
import com.springSecurity.SpringSecurity2.models.UserEntity;
import com.springSecurity.SpringSecurity2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
public class SpringSecurity2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurity2Application.class, args);
	}

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserRepository userRepository;
	@Bean
	CommandLineRunner init(){return args -> {

		UserEntity userEntity = UserEntity.builder()
				.email("cala@gmail.com")
				.username("milo")
				.password(passwordEncoder.encode("1234"))
				.roles(Set.of(RoleEntity.builder()
						.name(ERole.valueOf(ERole.ADMIN.name()))
						.build()))
				.build();

		UserEntity userEntity2 = UserEntity.builder()
				.email("luz@gmail.com")
				.username("luz")
				.password(passwordEncoder.encode("1234"))
				.roles(Set.of(RoleEntity.builder()
						.name(ERole.valueOf(ERole.USER.name()))
						.build()))
				.build();

		UserEntity userEntity3 = UserEntity.builder()
				.email("lila@gmail.com")
				.username("lila")
				.password(passwordEncoder.encode("1234"))
				.roles(Set.of(RoleEntity.builder()
						.name(ERole.valueOf(ERole.INVITED.name()))
						.build()))
				.build();

		userRepository.save(userEntity);
		userRepository.save(userEntity2);
		userRepository.save(userEntity3);


	};
	}
}
