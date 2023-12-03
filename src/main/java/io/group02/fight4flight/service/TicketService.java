package io.group02.fight4flight.service;

import io.group02.fight4flight.model.Ticket;
import io.group02.fight4flight.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    // Method to create a new ticket
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    // Method to get all tickets
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    // Method to get a ticket by ID
    public Optional<Ticket> getTicketById(Long ticketId) {
        return ticketRepository.findById(ticketId);
    }

    // Method to update an existing ticket
    public Ticket updateTicket(Long ticketId, Ticket ticketDetails) {
        Ticket ticket = ticketRepository.findById(ticketId)
            .orElseThrow(() -> new RuntimeException("Ticket not found with id " + ticketId));
        // Update ticket details here
        return ticketRepository.save(ticket);
    }

    // Method to delete a ticket
    public void deleteTicket(Long ticketId) {
        ticketRepository.deleteById(ticketId);
    }

    // Additional methods as required
}
