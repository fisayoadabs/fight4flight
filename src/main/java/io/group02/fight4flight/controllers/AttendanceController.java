// package io.group02.fight4flight.controllers;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import io.group02.fight4flight.model.Attendance;
// import io.group02.fight4flight.model.Unregistered;
// import io.group02.fight4flight.service.AttendanceService;
// import io.group02.fight4flight.service.UnregisteredService;

// @RestController
// @RequestMapping("/attendance")
// @CrossOrigin
// public class AttendanceController {
//     @Autowired
//     private AttendanceService attendanceService;
//     @Autowired
//     private UnregisteredService unregisteredService;

//     @PostMapping("/add")
//     public ResponseEntity<String> addAttendance(@RequestBody Attendance attendance) {
//         // Create and save Unregistered user
//         Unregistered unregisteredUser = new Unregistered(attendance.getEmail(), attendance.getFname(), attendance.getLname());
//         unregisteredService.saveUnregistered(unregisteredUser);
//         attendanceService.saveAttendance(attendance);
//         return ResponseEntity.ok("Attendance added successfully");
//     }

//     @GetMapping("/getAll")
//     public List<Attendance> list() {
//         return attendanceService.getAllAttendances();
//     }
// }
