package com.example.AirLineResevationSystems.service;

import com.example.AirLineResevationSystems.entity.Airport;
import com.example.AirLineResevationSystems.model.AirportModel;

import com.example.AirLineResevationSystems.repository.AirportRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

@Service
public class AirportService {
    @Autowired
    public AirportRepository airportRepository;
    @Transactional
    public AirportModel Save(AirportModel airportModel)
    {
        Airport airport = null;
        if(!ObjectUtils.isEmpty(airportModel))
        {
            airport = findExistingAirport(airportModel);
            if(ObjectUtils.isEmpty(airport))
            {
                airport = airportModel.disassemble();
            }
            else
            {
                airport.setAirportname(airportModel.getAirportname());
                airport.setLocation(airportModel.getLocation());

            }
        }
        return new AirportModel(airportRepository.save(airport));
    }



    private Airport findExistingAirport(AirportModel airportModel) {
        Airport airport = null ;
        if(!ObjectUtils.isEmpty(airportModel.getAirPortId()))
        {
            airport = airportRepository.findAirportByairPortId(airportModel.getAirPortId());
        }
        else if (!StringUtils.isEmpty(airportModel.getAirportname()));
        {
            airport = airportRepository.findAirportByairportname(airportModel.getAirportname());
        }
        return airport;
    }}


  /*  public AirportModel insert(AirportModel airportModel){
        return airportModel.assemble(airportRepository.save(airportModel.disassemble()));
    }
}
*/
