package io.group02.fight4flight.service;

import java.util.List;

import io.group02.fight4flight.model.Aircraft;
import io.group02.fight4flight.model.Seat;

public interface AircraftService {
    public Aircraft saveAircraft(Aircraft customer);

    public List<Aircraft> getAllAircrafts();

    // public List<Seat> getAllSeats(Long id);
    // // public Aircraft findById(int long1);
}
