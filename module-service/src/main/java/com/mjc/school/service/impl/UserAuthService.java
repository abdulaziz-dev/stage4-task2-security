package com.mjc.school.service.impl;

import com.mjc.school.repository.interfaces.RoleRepository;
import com.mjc.school.repository.interfaces.UserRepository;
import com.mjc.school.repository.model.RoleModel;
import com.mjc.school.repository.model.UserModel;
import com.mjc.school.service.dto.LoginDTO;
import com.mjc.school.service.dto.RegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserAuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserAuthService(UserRepository userRepository, RoleRepository roleRepository,
                           PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = encoder;
    }

    public boolean register(RegisterDTO registerDTO){
        if (userRepository.existsByUsername(registerDTO.username())){
            return false;
        }
        UserModel user = new UserModel();
        user.setUsername(registerDTO.username());
        user.setPassword(passwordEncoder.encode(registerDTO.password()));

        RoleModel role = roleRepository.findByName("ROLE_USER").get();
        user.setRoles(Collections.singleton(role));

        userRepository.save(user);
        return true;
    }

}
