package io.group02.fight4flight.model;

import jakarta.persistence.*;

@Entity
public class Admin {
    @Id
    private Long adminid;
    private String username;
    private String password;
    
}
