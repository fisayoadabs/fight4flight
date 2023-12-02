package io.group02.fight4flight.service;

import java.util.List;

import java.util.Optional;


import io.group02.fight4flight.model.Aircraft;

public interface AircraftService {
    Aircraft saveAircraft(Aircraft customer);

    List<Aircraft> getAllAircrafts();

    Aircraft findById(Long aircraftID);

    Optional<Aircraft> findAircraftById(Long aircraftID);

    void deleteAircraftById(Long aircraftId);
}
