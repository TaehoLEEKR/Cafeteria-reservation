package com.mission.cafeteria.domain.repository;

import com.mission.cafeteria.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);
    //Optional<Customer> findByEmailAndCustomer_verify(String email);
}
