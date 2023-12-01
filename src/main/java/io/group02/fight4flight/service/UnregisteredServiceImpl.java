package io.group02.fight4flight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.group02.fight4flight.model.Unregistered;
import io.group02.fight4flight.repository.RegisteredRepository;
import io.group02.fight4flight.repository.UnregisteredRepository;

import java.util.List;

@Service
public class UnregisteredServiceImpl implements UnregisteredService {

    @Autowired
    private UnregisteredRepository customerRepository;

    @Autowired
    private RegisteredRepository regsteredRepo;

    @Override
    public Unregistered saveUnregistered(Unregistered customer) {
        System.out.println(customer.getEmail());
        return customerRepository.save(customer);
    }

    @Override
    public List<Unregistered> getAllUnregistereds() {
        return customerRepository.findAll();
    }
}
