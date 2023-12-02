package io.group02.fight4flight.service;

import java.util.List;

import io.group02.fight4flight.model.Flight;

public interface FlightService {
    public Flight saveFlight(Flight plane);

    public List<Flight> getAllFlights();

    Flight findById(Long flightid);
}
