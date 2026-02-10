package com.fpt.dangkhoa.service;

import com.fpt.dangkhoa.dto.LoginRequest;
import com.fpt.dangkhoa.dto.RegisterRequest;
import com.fpt.dangkhoa.entity.Cart;
import com.fpt.dangkhoa.entity.Customer;
import com.fpt.dangkhoa.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CustomerAuthService {

    private final CustomerRepository customerRepository;

    // ===== LOGIN =====
    public Customer login(LoginRequest request) {

        Customer customer = customerRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Email not found"));

        if (!customer.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return customer;
    }

    // ===== REGISTER =====
    public Customer register(RegisterRequest request) {

        if (customerRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());
        customer.setPassword(request.getPassword());
        customer.setCreatedAt(LocalDateTime.now());

        Cart cart = new Cart();
        cart.setCustomer(customer);
        cart.setStatus("ACTIVE");
        cart.setCreatedAt(LocalDateTime.now());

        customer.setCart(cart);

        return customerRepository.save(customer);
    }
}
