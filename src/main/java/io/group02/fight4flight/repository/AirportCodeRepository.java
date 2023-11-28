package io.group02.fight4flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.group02.fight4flight.domain.AirportCode;
public interface AirportCodeRepository extends JpaRepository<AirportCode, Long>{}
