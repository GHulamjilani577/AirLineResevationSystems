package com.example.AirLineResevationSystems.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;
    @Column(name="user_Name")
    private String userName;
    @Column(name="CNIC_Number")
    private String CNICNumber;
    @Column(name="Phone_number")
    private String phoneNumber;
    @OneToMany
    private List<Reservation>reservations;

}
