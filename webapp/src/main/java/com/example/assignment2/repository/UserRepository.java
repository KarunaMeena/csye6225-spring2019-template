package com.example.assignment2.repository;

import com.example.assignment2.BO.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {


}
