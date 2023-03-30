package com.example.AirLineResevationSystems.repository;

import com.example.AirLineResevationSystems.entity.Airport;
import com.example.AirLineResevationSystems.model.AirportModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AirportRepository extends JpaRepository<Airport,Long> {

    Airport findByairPortId(Long airPortId);

    Airport findByairportname(String airportname);

    Airport findByAirportname(String name);


    List<Airport> findByLocation(String location);
}
