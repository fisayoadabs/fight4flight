package io.group02.fight4flight.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Collectors;
import io.group02.fight4flight.DTO.AircraftDTO;
import io.group02.fight4flight.DTO.CrewDTO;
import io.group02.fight4flight.DTO.FlightDTO;
import io.group02.fight4flight.DTO.SeatDTO;
import io.group02.fight4flight.model.Aircraft;
import io.group02.fight4flight.model.AirportCode;
import io.group02.fight4flight.model.CrewMember;
import io.group02.fight4flight.model.Flight;
import io.group02.fight4flight.model.Seat;
import io.group02.fight4flight.service.AircraftService;
import io.group02.fight4flight.service.AirportCodeService;
import io.group02.fight4flight.service.CrewMemberService;
import io.group02.fight4flight.service.FlightService;
import io.group02.fight4flight.service.SeatService;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/flight-management")
@CrossOrigin
public class FlightController {
    @Autowired
    private AircraftService aircraftService;
    @Autowired
    private AirportCodeService airportCodeService;
    @Autowired
    private FlightService flightService;
    @Autowired
    private SeatService seatService;

    @Autowired
    private CrewMemberService crewService;

    @PostMapping("/aircraft/add")
    public ResponseEntity<String> addAircraft(@RequestBody AircraftDTO aircraftDTO) {
        Aircraft aircraft = new Aircraft();
        aircraft.setAircraftID(aircraftDTO.getAircraftId());
        aircraft.setAircraftName(aircraftDTO.getAircraftName());
        aircraft.setModel(aircraftDTO.getModel());

        aircraftService.saveAircraft(aircraft);
        return ResponseEntity.ok("Aircraft added successfully");
    }

    @GetMapping("/aircraft/getAll")
    public ResponseEntity<List<AircraftDTO>> getAllAircrafts() {
        List<Aircraft> aircraftList = aircraftService.getAllAircrafts();
        List<AircraftDTO> aircraftDTOs = aircraftList.stream()
                .map(AircraftDTO::fromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(aircraftDTOs);
    }

    @DeleteMapping("/aircraft/remove/{aircraftId}")
    public ResponseEntity<?> removeAircraft(@PathVariable Long aircraftId) {
        try {
            aircraftService.deleteAircraftById(aircraftId);
            return ResponseEntity.ok("Aircraft and all related flights removed successfully");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aircraft not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred: " + e.getMessage());
        }
    }

    // Seat Endpoints
    @GetMapping("/seat/getAll")
    public List<Seat> getAllSeats() {
        return seatService.getAllSeats();
    }

    @GetMapping("/seat/getByAircraft/{aircraftid}")
    public ResponseEntity<List<Seat>> getSeatsByAircraft(@PathVariable Long aircraftid) {
        List<Seat> seats = seatService.getSeatsByAircraftId(aircraftid);
        if (seats.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(seats);
    }

    @PutMapping("/seat/occupy")
    public ResponseEntity<?> occupySeat(@RequestBody SeatDTO seatUpdateDTO) {
        Optional<Seat> seatOptional = seatService.getSeatById(seatUpdateDTO.getSeatId());

        if (!seatOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Seat seat = seatOptional.get();
        if (seat.getAircraft() == null || !seat.getAircraft().getAircraftID().equals(seatUpdateDTO.getAircraftId())) {
            return ResponseEntity.badRequest().body("Seat does not belong to the specified aircraft");
        }

        if (!seat.getVacancy()) {
            return ResponseEntity.badRequest().body("Seat is already occupied");
        }

        seat.setVacancy(false);
        seatService.saveSeat(seat);
        return ResponseEntity.ok("Seat occupied successfully");
    }

    @PutMapping("/seat/unoccupy")
    public ResponseEntity<?> unoccupySeatVacancy(@RequestBody SeatDTO seatUpdateDTO) {
        Optional<Seat> seatOptional = seatService.getSeatById(seatUpdateDTO.getSeatId());

        if (!seatOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Seat seat = seatOptional.get();
        if (seat.getAircraft() == null || !seat.getAircraft().getAircraftID().equals(seatUpdateDTO.getAircraftId())) {
            return ResponseEntity.badRequest().body("Seat does not belong to the specified aircraft");
        }

        if (seat.getVacancy()) {
            return ResponseEntity.badRequest().body("Seat is already unoccupied");
        }

        seat.setVacancy(true);
        seatService.saveSeat(seat);
        return ResponseEntity.ok("Seat remove successfully");
    }

    // Airport Code Endpoints
    @PostMapping("/airport/add")
    public ResponseEntity<String> addAirport(@RequestBody AirportCode port) {
        airportCodeService.saveAirport(port);
        return ResponseEntity.ok("Airport added successfully");
    }

    @GetMapping("/airport/getAll")
    public ResponseEntity<List<AirportCode>> getAllAirports() {
        return ResponseEntity.ok(airportCodeService.getAllAirports());
    }

    // Flight Endpoints
    @PostMapping("/addFlight")
    public ResponseEntity<String> addFlight(@RequestBody FlightDTO flightDTO) {
        Flight flight = new Flight();

        flight.setFlightid(flightDTO.getFlightId());
        Optional<AirportCode> depart = airportCodeService.findById(flightDTO.getDepartureId());
        flight.setDeparture(depart.get());
        Optional<AirportCode> destin = airportCodeService.findById(flightDTO.getDestinationId());
        flight.setDestination(destin.get());
        Aircraft kraft = aircraftService.findById(flightDTO.getAircraftId());
        flight.setAircraft(kraft);

        flight.setDepartureTime(flightDTO.getDepartureTime());

        flight.setArrivalTime(flightDTO.getArrivalTime());

        flightService.saveFlight(flight);
        return ResponseEntity.ok("Flight added successfully"); // This should now return a Flight object with the
                                                               // generated flightid
    }

    @GetMapping("/getAllFlights")
    public ResponseEntity<List<Flight>> getAllFlights() {
        return ResponseEntity.ok(flightService.getAllFlights());
    }

    @PutMapping("/modifyFlights")
    public ResponseEntity<?> modifyFlight(@RequestBody FlightDTO flightDTO) {
        try {
            Flight flight = flightService.findById(flightDTO.getFlightId());

            // Update the flight entity based on the provided DTO
            updateFlightEntity(flight, flightDTO);

            flightService.saveFlight(flight);

            return ResponseEntity.ok("Flight updated successfully");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    private void updateFlightEntity(Flight flight, FlightDTO flightDTO) {
        // Only update fields that are provided in the DTO
        if (flightDTO.getDepartureId() != null) {
            flight.setDeparture(airportCodeService.findById(flightDTO.getDepartureId()).orElse(null));
        }
        if (flightDTO.getDestinationId() != null) {
            flight.setDestination(airportCodeService.findById(flightDTO.getDestinationId()).orElse(null));
        }
        if (flightDTO.getAircraftId() != null) {
            flight.setAircraft(aircraftService.findById(flightDTO.getAircraftId()).orElse(null));
        }
        if (flightDTO.getDepartureTime() != null) {
            flight.setDepartureTime(flightDTO.getDepartureTime());
        }
        if (flightDTO.getArrivalTime() != null) {
            flight.setArrivalTime(flightDTO.getArrivalTime());
        }
    }

    @GetMapping("/workers/getCrewMem")
    public List<CrewMember> listsCrew() {
        return crewService.getAllCrewMembers();
    }

    @PostMapping("/workers/addCrewMem")
    public ResponseEntity<String> create(@RequestBody CrewMember pilot) {
        crewService.saveCrew(pilot);
        return ResponseEntity.ok("Crew member created");
    }

    @PutMapping("/workers/assignCrewMemToFlight")
    public ResponseEntity<?> assignCrewToFlight(@RequestBody CrewDTO crewAssignmentDTO) {
        try {
            crewService.assignCrewToFlight(crewAssignmentDTO.getCrewMemberId(), crewAssignmentDTO.getFlightId());
            return ResponseEntity.ok("Crew member assigned to flight successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/workers/removeCrewMemToFlight")
    public ResponseEntity<?> removeCrewToFlight(@RequestBody CrewDTO crewAssignmentDTO) {
        try {
            crewService.removeCrewToFlight(crewAssignmentDTO.getCrewMemberId(), crewAssignmentDTO.getFlightId());
            return ResponseEntity.ok("Crew member removed from flight successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

}
