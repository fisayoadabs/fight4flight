package io.group02.fight4flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.group02.fight4flight.model.Registered;

import java.util.List;

@Repository
public interface RegisteredRepository extends JpaRepository<Registered, String>{
    List<Registered> findByUsername(String username);

    // Registered getReferenceById(Long userId);
}
