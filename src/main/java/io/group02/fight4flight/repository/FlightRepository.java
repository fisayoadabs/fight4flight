package io.group02.fight4flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.group02.fight4flight.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>{}
