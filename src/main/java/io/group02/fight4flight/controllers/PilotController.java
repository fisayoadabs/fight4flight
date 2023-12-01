// package io.group02.fight4flight.controllers;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import io.group02.fight4flight.model.Pilot;
// import io.group02.fight4flight.service.PilotService;

// @RestController
// @RequestMapping("/pilot")
// @CrossOrigin
// public class PilotController {
//     @Autowired
//     private PilotService pilotService;

//     @PostMapping("/add")
//     public ResponseEntity<String> addPilot(@RequestBody Pilot pilot) {
//         pilotService.savePilot(pilot);
//         return ResponseEntity.ok("Pilot added successfully");
//     }

//     @GetMapping("/getAll")
//     public List<Pilot> list() {
//         return pilotService.getAllPilots();
//     }
// }
