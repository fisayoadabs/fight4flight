package io.group02.fight4flight.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.group02.fight4flight.domain.Aircraft;
import io.group02.fight4flight.repository.AircraftRepository;
import io.group02.fight4flight.service.AircraftService;

@RestController
@RequestMapping("/aircraft")
@CrossOrigin
public class AircraftController {
    @Autowired
    private AircraftService craftService;

    @PostMapping("/add")
    public String register(@RequestBody Aircraft craft) {
        craftService.saveAircraft(craft);
        return "You have added an aircraft";
    }

    @GetMapping("/getAll")
    public List<Aircraft> list() {
        return craftService.getAllAircrafts();
    }
}