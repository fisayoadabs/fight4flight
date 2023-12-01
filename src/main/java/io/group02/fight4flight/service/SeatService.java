package io.group02.fight4flight.service;

import java.util.List;

import io.group02.fight4flight.model.Seat;

public interface SeatService {
    public Seat addSeat(Seat chair);

    public List<Seat> getAllSeats();

    List<Seat> getSeatsByAircraftId(Long aircraftid);

    
}
