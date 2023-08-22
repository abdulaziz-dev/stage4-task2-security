package com.mjc.school.repository.interfaces;

import com.mjc.school.repository.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleModel, Long> {

    Optional<RoleModel> findByName(String name);

}
