package com.mjc.school.repository.interfaces;

import com.mjc.school.repository.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    Optional<UserModel> findByUsername(String username);
    Boolean existsByUsername(String username);

}
