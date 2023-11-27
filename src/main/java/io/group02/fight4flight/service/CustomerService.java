package io.group02.fight4flight.service;

import java.util.List;

import io.group02.fight4flight.domain.Customer;

public interface CustomerService {
    public Customer saveCustomer(Customer customer);
    public List<Customer> getAllCustomers();
}