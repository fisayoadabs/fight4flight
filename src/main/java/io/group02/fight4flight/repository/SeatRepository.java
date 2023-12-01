package io.group02.fight4flight.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.group02.fight4flight.model.Aircraft;
import io.group02.fight4flight.model.Seat;
import java.util.List;


public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByAircraftAircraftid(Long aircraftid);
}
