package io.group02.fight4flight.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.group02.fight4flight.domain.AirportCode;
import io.group02.fight4flight.service.AirportCodeService;

@RestController
@RequestMapping("/airport")
@CrossOrigin
public class AirportCodeController {
    @Autowired
    private AirportCodeService portService;

    @PostMapping("/add")
    public String register(@RequestBody AirportCode port) {
        portService.saveAirport(port);
        return "You have added an Airport";
    }

    @GetMapping("/getAll")
    public List<AirportCode> list() {
        return portService.getAllAirports();
    }
}
