package io.group02.fight4flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.group02.fight4flight.model.Aircraft;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, Long> {

    // List<Seat> findAllSeatsOnAircraft(Long id);
    // Aircraft findById(int id); 
}
