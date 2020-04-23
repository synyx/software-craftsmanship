package de.synyx.softwarecraftsmanship.customer.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import de.synyx.softwarecraftsmanship.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}