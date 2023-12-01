package io.group02.fight4flight.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Collectors;
import io.group02.fight4flight.DTO.AircraftDTO;
import io.group02.fight4flight.DTO.FlightDTO;
import io.group02.fight4flight.model.Aircraft;
import io.group02.fight4flight.model.AirportCode;
import io.group02.fight4flight.model.Flight;
import io.group02.fight4flight.model.Seat;
import io.group02.fight4flight.service.AircraftService;
import io.group02.fight4flight.service.AirportCodeService;
import io.group02.fight4flight.service.FlightService;
import io.group02.fight4flight.service.SeatService;

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

    // Aircraft Endpoints
    // @PostMapping("/aircraft/add")
    // public ResponseEntity<String> addAircraft(@RequestBody Aircraft craft) {
    // aircraftService.saveAircraft(craft);
    // return ResponseEntity.ok("Aircraft added successfully");
    // }

    @PostMapping("/aircraft/add")
    public ResponseEntity<String> addAircraft(@RequestBody AircraftDTO aircraftDTO) {
        Aircraft aircraft = new Aircraft();
        aircraft.setAircraftID(aircraftDTO.getAircraftId());
        aircraft.setAircraftName(aircraftDTO.getAircraftName());
        aircraft.setModel(aircraftDTO.getModel());
        // Set other fields as necessary

        aircraftService.saveAircraft(aircraft);
        return ResponseEntity.ok("Aircraft added successfully");
    }

    // @GetMapping("/aircraft/getAll")
    // public ResponseEntity<List<Aircraft>> getAllAircrafts() {
    // return ResponseEntity.ok(aircraftService.getAllAircrafts());
    // }

    @GetMapping("/aircraft/getAll")
    public ResponseEntity<List<AircraftDTO>> getAllAircrafts() {
        List<Aircraft> aircraftList = aircraftService.getAllAircrafts();
        List<AircraftDTO> aircraftDTOs = aircraftList.stream()
                .map(AircraftDTO::fromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(aircraftDTOs);
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
    // @PostMapping("/add")
    // public ResponseEntity<String> addFlight(@RequestBody Flight flight) {
    // flightService.saveFlight(flight);
    // return ResponseEntity.ok("Flight added successfully");
    // }

    //ADDING A FLIGHT DOES NOT WORK YET
    @PostMapping("/addFlight")
    public ResponseEntity<?> addFlight(@RequestBody FlightDTO flightDTO) {
        Flight flight = new Flight();

        // Set departure and destination
        airportCodeService.findById(flightDTO.getDepartureId()).ifPresent(flight::setDeparture);
        airportCodeService.findById(flightDTO.getDestinationId()).ifPresent(flight::setDestination);

        // Set aircraft
        aircraftService.findAircraftById(flightDTO.getAircraftId()).ifPresent(flight::setAircraft);

        // Set times
        flight.setDepartureTime(flightDTO.getDepartureTime());
        flight.setArrivalTime(flightDTO.getArrivalTime());

        flight = flightService.saveFlight(flight);
        return ResponseEntity.ok(flight);
    }

    @GetMapping("/getAllFlights")
    public ResponseEntity<List<Flight>> getAllFlights() {
        return ResponseEntity.ok(flightService.getAllFlights());
    }

}
