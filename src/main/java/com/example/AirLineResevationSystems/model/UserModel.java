package com.example.AirLineResevationSystems.model;

import com.example.AirLineResevationSystems.entity.AirLineFlight;
import com.example.AirLineResevationSystems.entity.User;
import lombok.Data;

@Data
public class UserModel
{
    private Long id;
    private String userName;
    private String CNICNumber;
    private String phoneNumber;


    public User disassemble(){
        User user=new User();
        user.setId(id);
        user.setUserName(userName);
        user.setCNICNumber(CNICNumber);
        user.setPhoneNumber(phoneNumber);
        return user;
    }
    public UserModel assemble(User user){
        UserModel userModel=new UserModel(user);
        userModel.setId(user.getId());
        userModel.setUserName(user.getUserName());
        userModel.setCNICNumber(user.getCNICNumber());
        userModel.setPhoneNumber(user.getPhoneNumber());
        return userModel;
    }
   public UserModel(Long id, String userName, String CNICNumber, String phoneNumber) {
       this.id = id;
       this.userName = userName;
       this.CNICNumber = CNICNumber;
       this.phoneNumber = phoneNumber;
   }

    public UserModel(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.CNICNumber = user.getCNICNumber();
        this.phoneNumber = user.getPhoneNumber();
    }
}
