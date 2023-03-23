package com.example.AirLineResevationSystems.repository;

import com.example.AirLineResevationSystems.entity.FlightSchedule;
import com.example.AirLineResevationSystems.model.FlightScheduleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightScheduleRepository extends JpaRepository<FlightSchedule,Long> {


}
