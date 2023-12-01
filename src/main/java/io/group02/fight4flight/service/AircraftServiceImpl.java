package io.group02.fight4flight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.group02.fight4flight.model.Aircraft;
import io.group02.fight4flight.model.Seat;
import io.group02.fight4flight.repository.AircraftRepository;

import java.util.List;

@Service
public class AircraftServiceImpl implements AircraftService {

    @Autowired
    private AircraftRepository craftRepository;

    @Override
    public Aircraft saveAircraft(Aircraft craft) {
        // Save the aircraft along with its initialized seats
        return craftRepository.save(craft);
    }
    
    @Override
    public List<Aircraft> getAllAircrafts() {
        return craftRepository.findAll();
    }

    // @Override 
    // public List<Seat> getAllSeats(Long id) {
    //     return craftRepository.findAllSeatsOnAircraft(id);
    // }
    // @Override
    // public Aircraft findById(int aircraftId){
    //     return craftRepository.findById(aircraftId);
    // }
}
