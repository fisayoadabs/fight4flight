package io.group02.fight4flight.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.group02.fight4flight.domain.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long>{
    Optional<Seat> findById(Long id);
}
