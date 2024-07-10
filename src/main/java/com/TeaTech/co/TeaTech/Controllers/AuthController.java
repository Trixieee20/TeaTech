package com.TeaTech.co.TeaTech.Controllers;


import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TeaTech.co.TeaTech.DTO.LoginRequest;
import com.TeaTech.co.TeaTech.DTO.RegistrationRequest;
import com.TeaTech.co.TeaTech.Model.Role;
import com.TeaTech.co.TeaTech.Model.UserAuth;
import com.TeaTech.co.TeaTech.Repository.RoleRepository;
import com.TeaTech.co.TeaTech.Repository.UserAuthRepository;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    UserAuthRepository userAuthRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegistrationRequest registrationRequest){

        if(userAuthRepository.existsByUsername(registrationRequest.getUsername())){
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        if(userAuthRepository.existsByEmail(registrationRequest.getEmail())){
            return new ResponseEntity<>("An account id already registered in this email", HttpStatus.BAD_REQUEST);
        }

        UserAuth user = new UserAuth(
            registrationRequest.getEmail(),
            registrationRequest.getUsername(),
            passwordEncoder.encode(registrationRequest.getPassword())
        );

        Role role = roleRepository.findByName("ROLE_ADMIN").get();
        user.setRoles(Collections.singleton(role));

        userAuthRepository.save(user);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }

    @PostMapping("/register/user")
    public ResponseEntity<?> registeruser(@RequestBody RegistrationRequest registrationRequest){

        if(userAuthRepository.existsByUsername(registrationRequest.getUsername())){
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        if(userAuthRepository.existsByEmail(registrationRequest.getEmail())){
            return new ResponseEntity<>("An account id already registered in this email", HttpStatus.BAD_REQUEST);
        }

        UserAuth user = new UserAuth(
            registrationRequest.getEmail(),
            registrationRequest.getUsername(),
            passwordEncoder.encode(registrationRequest.getPassword())
        );

        Role role = roleRepository.findByName("ROLE_USER").get();
        user.setRoles(Collections.singleton(role));

        userAuthRepository.save(user);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
        try{
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    loginRequest.getUsernameOrEmail(),
                    loginRequest.getPassword()
                )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            return new ResponseEntity<>("User logged in successfully", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.UNAUTHORIZED);
        }
    }
}
