package com.example.AirLineResevationSystems.service;
import com.example.AirLineResevationSystems.model.UserModel;
import com.example.AirLineResevationSystems.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    public UserRepository userRepository;
    public UserModel insert(UserModel userModel){
        return userModel.assemble(userRepository.save(userModel.disassemble()));
    }
}
