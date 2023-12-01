package io.group02.fight4flight.service;

import java.util.List;

import java.util.Optional;


import io.group02.fight4flight.model.Aircraft;

public interface AircraftService {
    public Aircraft saveAircraft(Aircraft customer);

    public List<Aircraft> getAllAircrafts();

    public Aircraft findById(Long aircraftID);

    Optional<Aircraft> findAircraftById(Long aircraftID);
}
