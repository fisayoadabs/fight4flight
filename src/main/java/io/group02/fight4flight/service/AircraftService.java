package io.group02.fight4flight.service;

import java.util.List;

import io.group02.fight4flight.domain.Aircraft;

public interface AircraftService {
    public Aircraft saveAircraft(Aircraft customer);
    public List<Aircraft> getAllAircrafts();
}
