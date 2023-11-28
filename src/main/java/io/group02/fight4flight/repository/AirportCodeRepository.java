package io.group02.fight4flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import io.group02.fight4flight.domain.AirportCode;

@Repository
public interface AirportCodeRepository extends JpaRepository<AirportCode, Long>{}
