package io.group02.fight4flight.repository;

import io.group02.fight4flight.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    // You can define custom query methods here, if needed.
}
