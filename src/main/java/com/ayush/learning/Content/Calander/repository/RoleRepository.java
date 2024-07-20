package com.ayush.learning.Content.Calander.repository;

import com.ayush.learning.Content.Calander.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<RoleRepository> findByName(String name);
}
