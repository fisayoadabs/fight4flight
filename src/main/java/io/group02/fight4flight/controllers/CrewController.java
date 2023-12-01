// package io.group02.fight4flight.controllers;

// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import io.group02.fight4flight.model.Attendance;
// import io.group02.fight4flight.model.Crew;
// import io.group02.fight4flight.model.Unregistered;
// import io.group02.fight4flight.repository.CrewRepository;
// import io.group02.fight4flight.service.AttendanceService;
// import io.group02.fight4flight.service.CrewService;
// import io.group02.fight4flight.service.UnregisteredService;


// @RestController
// @RequestMapping("/crew")
// @CrossOrigin
// public class CrewController {
//     @Autowired
//     private CrewService crewService;

//     @Autowired
//     private AttendanceService userService;

//     @PostMapping(value="/add")
//     public String add(@RequestBody Crew crewadd) {
//         Attendance attendance= new Attendance( new Unregistered(crewadd.getFlightAttendances().get(0).getEmail(),
//                 crewadd.getFlightAttendances().get(0).getFname(), crewadd.getFlightAttendances().get(0).getLname()),
//                 crewadd.getFlightAttendances().get(0).getPassword(), crewadd.getFlightAttendances().get(0).getAddress(), crewadd.getFlightAttendances().get(0).getPassword());
//         userService.saveAttendance(attendance);
//         crewService.saveCrew(crewadd);
        
//         return "crew member has been added";
//     }

//     @GetMapping(value="/getAll")
//     public List<Crew> list() {
//         return crewService.getAllCrews();
//     }}
    