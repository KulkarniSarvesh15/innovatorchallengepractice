package com.innovatorchallenge.practice.controller;

import com.innovatorchallenge.practice.model.User;
import com.innovatorchallenge.practice.service.UserService;
import com.innovatorchallenge.practice.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    public UserService userService;

    @Autowired
    public AuthenticationManager authenticationManager;

    @Autowired
    public JWTUtil jwtUtil;

    @GetMapping("/authenticate")
    public ResponseEntity autheticateUser(@RequestBody User user){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword()));
        } catch (Exception e){
            return new ResponseEntity<>("User Credentials Invalid", HttpStatus.BAD_REQUEST);
        }
        //return new ResponseEntity<>(jwtUtil.generateToken(user.getUserName()),HttpStatus.OK);
        return new ResponseEntity<>(jwtUtil.generateToken(String.valueOf(user.getUserName())),HttpStatus.OK);
    }

    @PostMapping("/users/add")
    public ResponseEntity addUser(@RequestBody User user){
        userService.addUser(user);
        return new ResponseEntity<>(Collections.singletonMap("response","success"), HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity<>(userService.getUsers(),HttpStatus.OK);
    }
}
