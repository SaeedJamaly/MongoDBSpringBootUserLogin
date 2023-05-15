package com.punch.Spring_Boot_MongoDB_Punch.service;

import com.punch.Spring_Boot_MongoDB_Punch.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findByUserId(String id);
    User findByEmail(String email);
    List<User> findAllByOrderByName();
    User saveOrUpdateUser(User user);
    void deleteUserById(String id);
}
