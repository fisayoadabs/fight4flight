package io.group02.fight4flight.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.group02.fight4flight.DTO.CrewDTO;
import io.group02.fight4flight.model.CrewMember;
import io.group02.fight4flight.service.CrewMemberService;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/workers")
@CrossOrigin
public class AdminController {
    @Autowired
    private CrewMemberService crewService;

    @GetMapping("/getCrewMem")
    public List<CrewMember> listsCrew() {
        return crewService.getAllCrewMembers();
    }

    @PostMapping("/addCrewMem")
    public String create(@RequestBody CrewMember pilot) {
        crewService.saveCrew(pilot);
        return "Crew member created";
    }

   @PutMapping("/assignCrewMemToFlight")
    public ResponseEntity<?> assignCrewToFlight(@RequestBody CrewDTO crewAssignmentDTO) {
        crewService.assignCrewToFlight(crewAssignmentDTO.getCrewMemberId(), crewAssignmentDTO.getFlightId());
        return ResponseEntity.ok("Crew member assigned to flight successfully");
    }

    @DeleteMapping("/removeCrewMemToFlight")
    public ResponseEntity<?> removeCrewToFlight(@RequestBody CrewDTO crewAssignmentDTO) {
        crewService.removeCrewToFlight(crewAssignmentDTO.getCrewMemberId(), crewAssignmentDTO.getFlightId());
        return ResponseEntity.ok("Crew member removed from flight successfully");
    }
}
