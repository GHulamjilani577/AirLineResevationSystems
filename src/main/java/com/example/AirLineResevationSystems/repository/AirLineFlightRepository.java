package com.example.AirLineResevationSystems.repository;

import com.example.AirLineResevationSystems.entity.AirLineFlight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirLineFlightRepository extends JpaRepository<AirLineFlight,Long>
{

}
