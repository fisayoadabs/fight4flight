package io.group02.fight4flight.service;

import java.util.List;

import io.group02.fight4flight.model.Registered;

public interface RegisteredService {
    public Registered saveRegistered(Registered customer);

    public List<Registered> getAllRegistereds();

    // public Registered getRegisteredById(Long userId);

}
