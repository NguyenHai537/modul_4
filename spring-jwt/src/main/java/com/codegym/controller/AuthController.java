package com.codegym.controller;

import com.codegym.model.JwtResponse;
import com.codegym.model.User;
import com.codegym.service.IUserService;
import com.codegym.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        User user1 = null;
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
        if (userService.checkLogin(user)){
             user1 = userService.findByUsername(user.getUsername()).get();
        }

        String jwt = jwtService.generateTokenLogin(user1);

        return ResponseEntity.ok(new JwtResponse(jwt, user1.getId(), user1.getUsername(), user1.getFullName(),  user1.getRoles()));
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {

        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }
}
