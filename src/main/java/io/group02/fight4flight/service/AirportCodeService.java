package io.group02.fight4flight.service;

import java.util.List;

import io.group02.fight4flight.model.AirportCode;

public interface AirportCodeService {
    public AirportCode saveAirport(AirportCode customer);
    public List<AirportCode> getAllAirports();
    public AirportCode findByPortCode(String departureCode);
}
