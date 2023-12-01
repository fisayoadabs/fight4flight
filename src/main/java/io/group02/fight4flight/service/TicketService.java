package io.group02.fight4flight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.group02.fight4flight.DTO.TicketDTO;
import io.group02.fight4flight.model.Flight;
import io.group02.fight4flight.model.Seat;
import io.group02.fight4flight.model.Ticket;
import io.group02.fight4flight.model.Unregistered;
import io.group02.fight4flight.repository.FlightRepository;
import io.group02.fight4flight.repository.SeatRepository;
import io.group02.fight4flight.repository.TicketRepository;
import io.group02.fight4flight.repository.UnregisteredRepository;
import jakarta.persistence.*;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private UnregisteredRepository unregisteredRepository; 

    @Transactional
    public Ticket createTicket(TicketDTO ticketDto) {
        Flight flight = flightRepository.findById(ticketDto.getFlightId())
                           .orElseThrow(() -> new EntityNotFoundException("Flight not found"));
        Seat seat = seatRepository.findById(ticketDto.getSeatId())
                        .orElseThrow(() -> new EntityNotFoundException("Seat not found"));
        Unregistered user = unregisteredRepository.findByEmail(ticketDto.getUserEmail())
                           .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Ticket ticket = new Ticket();
        ticket.setFlight(flight);
        ticket.setSeat(seat);
        ticket.setUser(user); 

        return ticketRepository.save(ticket);
    }

    public void deleteTicket(Long ticketId, String userEmail) throws Exception {
        Ticket ticket = ticketRepository.findById(ticketId)
            .orElseThrow(() -> new EntityNotFoundException("Ticket not found"));

        if (!ticket.getUser().equals(userEmail)) {
            throw new Exception("You can only delete your tickets");
        }

        ticketRepository.delete(ticket);
    }
}
