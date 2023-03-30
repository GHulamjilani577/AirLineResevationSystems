package com.example.AirLineResevationSystems.repository;
import com.example.AirLineResevationSystems.entity.User;
import com.example.AirLineResevationSystems.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    List<UserModel> findByIdAndUserName(Long id, String userName);

    User findByUserName(String userName);

    User findByUserNameAndCNICNumber(String userName, String cnicNumber);

}
