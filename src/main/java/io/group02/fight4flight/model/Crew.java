// package io.group02.fight4flight.model;

// import java.util.ArrayList;
// import java.util.Date;
// import java.util.List;

// import com.fasterxml.jackson.annotation.JsonManagedReference;

// import jakarta.persistence.*;

// @Entity
// @Table(name = "CREW")
// public class Crew {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private long crewid;

//     // @ManyToOne
//     // private Pilot pilot;

//     // @ManyToOne
//     // private Pilot cPilot;

//     @OneToMany(mappedBy = "attendanceid", cascade = CascadeType.ALL)
//     @JsonManagedReference
//     private List<Attendance> flightAttendances;

//     @OneToOne
//     private Flight flight;
//     // Add other fields as needed

//     public long getCrewid() {
//         return crewid;
//     }

//     // public Pilot getPilot() {
//     //     return pilot;
//     // }

//     // public void setPilot(Pilot pilot) {
//     //     this.pilot = pilot;
//     // }

//     // public Pilot getcPilot() {
//     //     return cPilot;
//     // }

//     // public void setcPilot(Pilot cPilot) {
//     //     this.cPilot = cPilot;
//     // }

//     public List<Attendance> getFlightAttendances() {
//         return flightAttendances;
//     }

//     // public void setFlightAttendances(List<Attendance> flightAttendances) {
//     //     this.flightAttendances = flightAttendances;
//     // }

//     // Add other getters and setters as needed
// }
