package com.example.AirLineResevationSystems.repository;

import com.example.AirLineResevationSystems.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirLineRepository extends JpaRepository<Airline,Integer> {
}
