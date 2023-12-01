package io.group02.fight4flight.service;

import java.util.List;
import java.util.Optional;
import io.group02.fight4flight.model.AirportCode;

public interface AirportCodeService {
    AirportCode saveAirport(AirportCode airportCode);
    List<AirportCode> getAllAirports();
    Optional<AirportCode> findById(Long id); // Returns an Optional
}
