package com.springSecurity.SpringSecurity2.controllers;

import com.springSecurity.SpringSecurity2.models.ERole;
import com.springSecurity.SpringSecurity2.models.RoleEntity;
import com.springSecurity.SpringSecurity2.models.UserEntity;
import com.springSecurity.SpringSecurity2.repositories.UserRepository;
import com.springSecurity.SpringSecurity2.requests.CreateUserDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class PrincipalController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/hello")
    public String hello(){
        return "Hello Gente! NO Asegurado";
    }
    @GetMapping("/helloSecured")
    public String helloSecured(){
        return "Hello Gente Asegurado!!!";
    }
    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserDTO createUserDTO){

        Set<RoleEntity> roles = createUserDTO.getRoles().stream()
                .map(role -> RoleEntity.builder()
                        .name(ERole.valueOf(role))
                        .build())
                .collect(Collectors.toSet());

        UserEntity userEntity = UserEntity.builder()
                .username(createUserDTO.getUsername())
                .password(createUserDTO.getPassword())
                .email(createUserDTO.getEmail())
                .roles(roles)
                .build();

        userRepository.save(userEntity);

        return ResponseEntity.ok(userEntity);
    }
    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestParam String id){
        userRepository.deleteById(Long.parseLong(id));
        return "Se ha borrado al usuariocon id: ".concat(id);
    }
}
