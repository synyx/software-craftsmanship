package de.synyx.softwarecraftsmanship.customer.service;

import org.springframework.stereotype.Service;

import de.synyx.softwarecraftsmanship.customer.persistence.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Boolean exists(Long customerId) {
        return customerRepository.existsById(customerId);
    }

}