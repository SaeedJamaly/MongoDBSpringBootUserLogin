package com.punch.Spring_Boot_MongoDB_Punch.controller;

import com.punch.Spring_Boot_MongoDB_Punch.dto.UserDTO;
import com.punch.Spring_Boot_MongoDB_Punch.model.User;
import com.punch.Spring_Boot_MongoDB_Punch.service.UserService;
import com.punch.Spring_Boot_MongoDB_Punch.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public List<UserDTO> getAllUsers(){
        return ObjectMapperUtils.mapAll(userService.findAll(), UserDTO.class);
    }

    @GetMapping(value = "/byId/{id}")
    public UserDTO getUserById(@PathVariable("id") String id) {
        return ObjectMapperUtils.map(userService.findByUserId(id), UserDTO.class);
    }

    @GetMapping(value = "/byEmail/{email}")
    public UserDTO getUserByEmail(@PathVariable("email") String email) {
        return ObjectMapperUtils.map(userService.findByEmail(email), UserDTO.class);
    }

    @GetMapping(value = "/orderByName")
    public List<UserDTO> findAllByOrderByGpaDesc() {
        return ObjectMapperUtils.mapAll(userService.findAllByOrderByName(), UserDTO.class);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveOrUpdateUser(@RequestBody UserDTO userDTO) {
        userService.saveOrUpdateUser(ObjectMapperUtils.map(userDTO, User.class));
        return new ResponseEntity("User added successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable String id) {
        userService.deleteUserById(userService.findByUserId(id).getId());
        return new ResponseEntity("User deleted successfully", HttpStatus.OK);
    }

}

