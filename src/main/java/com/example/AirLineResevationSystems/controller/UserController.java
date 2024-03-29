package com.example.AirLineResevationSystems.controller;
import com.example.AirLineResevationSystems.entity.User;
import com.example.AirLineResevationSystems.model.UserModel;
import com.example.AirLineResevationSystems.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    public UserService userService;

    // Add user
    @PostMapping(value = "/save")
    public UserModel addUser(@RequestBody UserModel userModel) {
        return userService.insert(userModel);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping
    public List<UserModel> getUsers(@RequestParam(name = "id", required = false) Long id,
                                    @RequestParam(name = "userName", required = false) String userName) {
        List<User> userList = userService.findUsers(id, userName);
        List<UserModel> userModelList = new ArrayList<>();
        for (User user : userList) {
            userModelList.add(new UserModel(user));
        }
        return userModelList;
    }

    @GetMapping("/userNameAndCNIC/{userName}/{CNICNumber}")
    public ResponseEntity<UserModel> getUserByNameAndCNIC(
            @PathVariable(value = "userName") String userName,
            @PathVariable(value = "CNICNumber") String CNICNumber
    ) {
        User user = userService.findUserByNameAndCNIC(userName, CNICNumber);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }else {
        UserModel userModel = new UserModel(user);
        return ResponseEntity.ok().body(userModel);
    }}
}


