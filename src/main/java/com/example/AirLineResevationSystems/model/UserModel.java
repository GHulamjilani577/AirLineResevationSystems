package com.example.AirLineResevationSystems.model;

import com.example.AirLineResevationSystems.entity.AirLineFlight;
import com.example.AirLineResevationSystems.entity.User;
import lombok.Data;

@Data
public class UserModel
{
    private Long id;
    private String passengerName;
    private String priorityBoarding;
    public User disassemble(){
        User user=new User();
        user.setId(id);
        user.setPassengerName(passengerName);
        user.setPriorityBoarding(priorityBoarding);
        return user;
    }
    public UserModel assemble(User user){
        UserModel userModel=new UserModel();
        userModel.setId(user.getId());
        userModel.setPassengerName(user.getPassengerName());
        userModel.setPriorityBoarding(user.getPriorityBoarding());
        return userModel;
    }
}
