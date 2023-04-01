package com.example.AirLineResevationSystems.service;
import com.example.AirLineResevationSystems.entity.AirLineFlight;
import com.example.AirLineResevationSystems.entity.FlightSchedule;
import com.example.AirLineResevationSystems.entity.User;
import com.example.AirLineResevationSystems.model.UserModel;
import com.example.AirLineResevationSystems.repository.FlightScheduleRepository;
import com.example.AirLineResevationSystems.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public FlightScheduleService flightScheduleService;
    public UserModel insert(UserModel userModel){
        return userModel.assemble(userRepository.save(userModel.disassemble()));
    }

   public List<User> findUsers(Long id, String userName) {
       if (id != null && userName != null) {
           userRepository.findByIdAndUserName(id, userName);
       } else if (id != null) {
          userRepository.findById(id);
       } else if (userName != null) {
         userRepository.findByUserName(userName);
       }
           return userRepository.findAll();
       }
    /*public User findUserByName(String userName) {
        User user = null;
        if (userName != null) {
            List<User> users = (List<User>) userRepository.findByUserName(userName);
            if (!users.isEmpty()) {
                user = users.get(0);
            }
        }
        return user;
    }*/
    public User findUserByNameAndCNIC(String userName, String CNICNumber) {
        return  userRepository.findByUserNameAndCNICNumber(userName, CNICNumber);
    }

    public void deleteUserByNameAndCnic(String userName, String CNICNumber) {
        User userToDelete = (User) userRepository.findByUserNameAndCNICNumber(userName, CNICNumber);
        if (userToDelete != null) {
            userRepository.delete(userToDelete);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Airline flight not found with id: " + id));
        userRepository.delete(user);

    }
}


