package com.punch.Spring_Boot_MongoDB_Punch.service.impl;

import com.punch.Spring_Boot_MongoDB_Punch.model.User;
import com.punch.Spring_Boot_MongoDB_Punch.repository.UserRepository;
import com.punch.Spring_Boot_MongoDB_Punch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    public User findByUserId(String id){
        return userRepository.findByUserId(id);
    }

    @Override
    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findAllByOrderByName(){
        return userRepository.findAllByOrderByName();
    }

    @Override
    public User saveOrUpdateUser(User user){
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(String id){
        userRepository.deleteById(id);
    }
}
