package io.group02.fight4flight.service;

import java.util.List;

import io.group02.fight4flight.model.Unregistered;

public interface UnregisteredService {
    public Unregistered saveUnregistered(Unregistered customer);
    public List<Unregistered> getAllUnregistereds();
    public Unregistered getByEmail(String email);
}