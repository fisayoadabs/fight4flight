package io.group02.fight4flight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.group02.fight4flight.model.Registered;
import io.group02.fight4flight.repository.RegisteredRepository;

@Service
public class RegisteredServiceImpl implements RegisteredService {
     @Autowired
    private RegisteredRepository userRepository;

    @Override
    public Registered saveRegistered(Registered user) {
        return userRepository.save(user);
    }

    @Override
    public List<Registered> getAllRegistereds() {
        return userRepository.findAll();
    }

    @Override
    public Registered getRegisteredByEmail(String mail) {
        return userRepository.getReferenceById(mail);
    }

    
}
