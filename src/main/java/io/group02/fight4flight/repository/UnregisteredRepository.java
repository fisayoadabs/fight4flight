package io.group02.fight4flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.group02.fight4flight.domain.Unregistered;
import java.util.List;

@Repository
public interface UnregisteredRepository extends JpaRepository<Unregistered, Long> {
    List<Unregistered> findByEmail(String email);
}