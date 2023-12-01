package io.group02.fight4flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import io.group02.fight4flight.model.Ticket;
import jakarta.transaction.Transactional;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    
    @Query("SELECT t FROM TICKET t")
    List<Ticket> findAllTickets();

    @Modifying
    @Transactional
    @Query("DELETE FROM TICKET t WHERE t.ticketid = :ticketId OR t.passemail = :email")
    void deleteTicketByIdOrEmail(@Param("ticketId") Long ticketId, @Param("email") String email);

    List<Ticket> findByUser_Email(String email);
}
