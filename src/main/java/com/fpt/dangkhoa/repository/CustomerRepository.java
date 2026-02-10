package com.fpt.dangkhoa.repository;

import com.fpt.dangkhoa.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByEmail(String email);
    boolean existsByEmail(String email);
}
