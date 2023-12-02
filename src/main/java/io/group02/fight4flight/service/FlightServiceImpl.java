package io.group02.fight4flight.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.group02.fight4flight.model.Flight;
import io.group02.fight4flight.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {
    
    @Autowired
    private FlightRepository planeRepo;

    @Override
    public Flight saveFlight(Flight plane) {
        return planeRepo.save(plane);
    }

    @Override
    public List<Flight> getAllFlights() {
        return planeRepo.findAll();
    }

    @Override
    public Flight findById(Long flightid) {
        return planeRepo.getReferenceById(flightid);
    }

}
