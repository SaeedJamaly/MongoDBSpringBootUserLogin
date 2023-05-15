package com.punch.Spring_Boot_MongoDB_Punch.repository;

import com.punch.Spring_Boot_MongoDB_Punch.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    User findByUserId(String id);
    User findByEmail(String email);
    List<User> findAllByOrderByName();
}
