package io.group02.fight4flight.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.group02.fight4flight.model.Seat;
import io.group02.fight4flight.service.SeatService;

@RestController
@RequestMapping("/seat")
@CrossOrigin
public class SeatController {
    @Autowired
    private SeatService seatService;

    // @PostMapping("/add")
    // public String add(@RequestBody Seat chair) {
    //     seatService.addSeat(chair);
    //     return "You have added your seat";
    // }
    @PostMapping("/add")
    public ResponseEntity<String> addSeat(@RequestBody Seat chair) {
        System.out.println(chair);
        seatService.addSeat(chair);
        return ResponseEntity.ok("Seat added successfully");
    }

    @GetMapping("/getAll")
    public List<Seat> list() {
        return seatService.getAllSeats();
    }

}
