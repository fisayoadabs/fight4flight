package io.group02.fight4flight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.group02.fight4flight.model.AirportCode;
import io.group02.fight4flight.repository.AirportCodeRepository;

@Service
public class AirportCodeServiceImpl implements AirportCodeService {
    
    @Autowired
    private AirportCodeRepository airportRepo;

    @Override
    public AirportCode saveAirport(AirportCode craft) {
        return airportRepo.save(craft);
    }

    @Override
    public List<AirportCode> getAllAirports() {
        return airportRepo.findAll();
    }

    @Override
    public AirportCode findByPortCode(String departureCode) {
        return airportRepo.findByPortcode(departureCode);
    }
    
}
