package io.group02.fight4flight.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.group02.fight4flight.model.AirportCode;
import io.group02.fight4flight.repository.AirportCodeRepository;

@Service
public class AirportCodeServiceImpl implements AirportCodeService {

    @Autowired
    private AirportCodeRepository airportRepo;

    @Override
    public AirportCode saveAirport(AirportCode airportCode) {
        return airportRepo.save(airportCode);
    }

    @Override
    public List<AirportCode> getAllAirports() {
        return airportRepo.findAll();
    }

    @Override
    public Optional<AirportCode> findById(Long id) {
        return airportRepo.findById(id);
    }
}
