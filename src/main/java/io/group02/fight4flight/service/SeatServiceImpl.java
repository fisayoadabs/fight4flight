package io.group02.fight4flight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.group02.fight4flight.domain.Seat;
import io.group02.fight4flight.repository.SeatRepository;

@Service
public class SeatServiceImpl implements SeatService {
    @Autowired
    private SeatRepository seatRepo;

    @Override
    public Seat addSeat(Seat chair) {
        return seatRepo.save(chair);
    }

    @Override
    public List<Seat> getAllSeats() {
        return seatRepo.findAll();
    }
    
}
