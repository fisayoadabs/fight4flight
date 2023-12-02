package io.group02.fight4flight.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.group02.fight4flight.model.Seat;
import io.group02.fight4flight.repository.SeatRepository;

@Service
public class SeatService {
    @Autowired
    private SeatRepository seatRepo;

    public Seat addSeat(Seat chair) {
        return seatRepo.save(chair);
    }

    public List<Seat> getAllSeats() {
        return seatRepo.findAll();
    }
    
    public List<Seat> getSeatsByAircraftId(Long aircraftid) {
        return seatRepo.findByAircraftAircraftid(aircraftid);
    }

    public Optional<Seat> getSeatById(Long id) {
        return seatRepo.findById(id);
    }

    public Seat saveSeat(Seat seat) {
        return seatRepo.save(seat);
    }
}
