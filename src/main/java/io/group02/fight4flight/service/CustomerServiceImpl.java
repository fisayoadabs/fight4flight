// package io.group02.fight4flight.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import io.group02.fight4flight.domain.Customer;
// import io.group02.fight4flight.repository.CustomerRepository;

// import java.util.List;

// @Service
// public class CustomerServiceImpl implements CustomerService {

//     @Autowired
//     private CustomerRepository customerRepository;

//     @Override
//     public Customer saveCustomer(Customer customer) {
//         return customerRepository.save(customer);
//     }

//     @Override
//     public List<Customer> getAllCustomers() {
//         return customerRepository.findAll();
//     }
// }
package io.group02.fight4flight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.group02.fight4flight.domain.Customer;
import io.group02.fight4flight.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

// @Service
// public class CustomerServiceImpl implements CustomerService {

//     @Autowired
//     private CustomerRepository customerRepository;

//     @Override
//     public Customer saveCustomer(Customer customer) {
//         // Check if the customer already exists in the database
//         Optional<Customer> existingCustomer = customerRepository.findById(customer.GetId());

//         if (existingCustomer.isPresent()) {
//             // If the customer exists, update the existing record
//             Customer updatedCustomer = existingCustomer.get();
//             updatedCustomer.SetFName(customer.GetFName());
//             updatedCustomer.SetLName(customer.GetLName());
//             updatedCustomer.SetEmail(customer.GetEmail());

//             return customerRepository.save(updatedCustomer);
//         } else {
//             // If the customer does not exist, save a new record
//             return customerRepository.save(customer);
//         }
//     }

//     @Override
//     public List<Customer> getAllCustomers() {
//         return customerRepository.findAll();
//     }
// }

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
