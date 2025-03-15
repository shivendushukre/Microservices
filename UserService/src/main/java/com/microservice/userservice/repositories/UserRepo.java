package com.microservice.userservice.repositories;

import com.microservice.userservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {

    // custom methods can be added
}
