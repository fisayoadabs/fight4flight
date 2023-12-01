// package io.group02.fight4flight.model;

// import com.fasterxml.jackson.annotation.JsonBackReference;

// import jakarta.persistence.*;

// @Entity
// public class Attendance extends Unregistered {

//     private int attendanceid;

//     private String address;
//     private String username;
//     private String password;

//     @ManyToOne
//     @JsonBackReference
//     // @JoinColumn(name = "crewid") // Foreign key column in Attendance table
//     private Crew crewnum;

//     public Attendance(Unregistered user, String address, String username, String password) {
//         super(user.getFname(), user.getLname(), user.getEmail());
//         this.address = address;
//         this.username = username;
//         this.password = password;
//     }

//     public int getAttendanceID() {
//         return this.attendanceid;
//     }

//     public String getAddress() {
//         return address;
//     }

//     public void setAddress(String address) {
//         this.address = address;
//     }

//     public String getUsername() {
//         return username;
//     }

//     public void setUsername(String username) {
//         this.username = username;
//     }

//     public String getPassword() {
//         return password;
//     }

//     public void setPassword(String password) {
//         this.password = password;
//     }

// }
