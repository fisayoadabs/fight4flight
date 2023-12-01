package io.group02.fight4flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.group02.fight4flight.model.AirportCode;

@Repository
public interface AirportCodeRepository extends JpaRepository<AirportCode, Long>{

    AirportCode findByPortcode(String departureCode);

}
