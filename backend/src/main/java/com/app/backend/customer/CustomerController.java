package com.app.backend.customer;

import java.util.UUID;

import javax.validation.Valid;

import com.app.backend.customer.dto.CreateCustomerDTO;
import com.app.backend.customer.dto.CustomerResponseDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomerController {
    private final CustomerService service;

    CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping("/auth/signup")
    public ResponseEntity<CustomerResponseDTO> signUp(@Valid @RequestBody CreateCustomerDTO createCustomerDTO) {
        return this.service.signIn(createCustomerDTO);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomerResponseDTO> getById(@PathVariable UUID id) {
        return this.service.getById(id);
    }

}
