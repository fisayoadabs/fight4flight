package io.group02.fight4flight.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.group02.fight4flight.model.Flight;
import io.group02.fight4flight.model.Unregistered;

@Repository
public interface UnregisteredRepository extends JpaRepository<Unregistered, String> {

    Optional<Flight> findByEmail(String userEmail);
}