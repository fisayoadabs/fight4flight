package io.group02.fight4flight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.group02.fight4flight.domain.Aircraft;
import io.group02.fight4flight.repository.AircraftRepository;

import java.util.List;

@Service
public class AircraftServiceImpl implements AircraftService {

    @Autowired
    private AircraftRepository craftRepository;

    @Override
    public Aircraft saveAircraft(Aircraft craft) {
        return craftRepository.save(craft);
    }

    @Override
    public List<Aircraft> getAllAircrafts() {
        return craftRepository.findAll();
    }
}
