package io.group02.fight4flight.service;

import java.util.List;

import io.group02.fight4flight.domain.Registered;

public interface RegisteredService {
    public Registered saveRegistered(Registered customer);

    public List<Registered> getAllRegistereds();
}
