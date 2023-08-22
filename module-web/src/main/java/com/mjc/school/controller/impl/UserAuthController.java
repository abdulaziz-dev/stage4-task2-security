package com.mjc.school.controller.impl;

import com.mjc.school.security.JWTGenerator;
import com.mjc.school.service.dto.AuthResponseDTO;
import com.mjc.school.service.dto.LoginDTO;
import com.mjc.school.service.dto.RegisterDTO;
import com.mjc.school.service.impl.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class UserAuthController {

    private final UserAuthService userAuthService;
    private final JWTGenerator jwtGenerator;
    private final AuthenticationManager authManager;

    @Autowired
    public UserAuthController(UserAuthService service, JWTGenerator generator, AuthenticationManager authManager){
        this.userAuthService = service;
        this.jwtGenerator = generator;
        this.authManager = authManager;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO){
        boolean success = userAuthService.register(registerDTO);
        if (success){
            return new ResponseEntity<>("User successfully registered!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("ERROR: User already exists.", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO loginDTO){
//        userAuthService.login(loginDTO);
        Authentication authentication = authManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        loginDTO.username(), loginDTO.password()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }


}
