package io.group02.fight4flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import io.group02.fight4flight.model.Ticket;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    // You can define custom query methods here if needed

    // Example: Find tickets by the email of the user who purchased them
    List<Ticket> findByPassemail(String passemail);
}
