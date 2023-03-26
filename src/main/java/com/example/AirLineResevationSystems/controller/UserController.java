package com.example.AirLineResevationSystems.controller;
import com.example.AirLineResevationSystems.model.UserModel;
import com.example.AirLineResevationSystems.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController
{
    @Autowired
    public UserService userService;
    @PostMapping("/add-user")
    public UserModel addUser(@RequestBody UserModel userModel){
        return userService.insert(userModel);
    }
}
