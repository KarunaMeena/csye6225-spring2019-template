package com.example.assignment2.service;

import com.example.assignment2.BO.User;

public interface UserService {

    User save(User user);
    boolean findUserbyUsername(String username);
    boolean checkAccount(String username, String password);
    //boolean findByUsernameAndPassword(String username, String password);
    //User findByUsername(String username);
}
