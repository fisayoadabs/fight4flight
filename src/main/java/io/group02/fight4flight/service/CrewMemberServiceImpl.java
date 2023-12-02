package io.group02.fight4flight.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.group02.fight4flight.model.CrewMember;
import io.group02.fight4flight.model.Flight;
import io.group02.fight4flight.repository.CrewMemberRepository;
import io.group02.fight4flight.repository.FlightRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CrewMemberServiceImpl implements CrewMemberService {
    @Autowired
    private CrewMemberRepository crewRepository;

    @Autowired
    private FlightRepository fly;

    @Override
    public CrewMember saveCrew(CrewMember customer) {

        return crewRepository.save(customer);
    }

    @Override
    public List<CrewMember> getAllCrewMembers() {
        return crewRepository.findAll();
    }

    @Override
    public void assignCrewToFlight(Long crewMemberId, Long flightId) {
        CrewMember crewMember = crewRepository.findById(crewMemberId)
                .orElseThrow(() -> new EntityNotFoundException("CrewMember not found"));

        Flight flight = fly.findById(flightId)
                .orElseThrow(() -> new EntityNotFoundException("Flight not found"));

        flight.addCrewMember(crewMember);
        fly.save(flight);
    }

    @Override
    public void removeCrewToFlight(Long crewMemberId, Long flightId) {
        CrewMember crewMember = crewRepository.findById(crewMemberId)
                .orElseThrow(() -> new EntityNotFoundException("CrewMember not found"));

        Flight flight = fly.findById(flightId)
                .orElseThrow(() -> new EntityNotFoundException("Flight not found"));

        flight.removeCrewMember(crewMember);
        fly.save(flight);
    }
}
