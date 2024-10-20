package com.dileep.SpringSecurityProject.repo;

import com.dileep.SpringSecurityProject.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users,Integer> {
    Users findByUsername(String username);
}
