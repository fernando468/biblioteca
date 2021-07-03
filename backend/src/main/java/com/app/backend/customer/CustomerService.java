package com.app.backend.customer;

import java.util.UUID;

import com.app.backend.customer.dto.CustomerResponseDTO;
import com.app.backend.customer.exceptions.UserIsAlreadyRegistered;
import com.app.backend.shared.exceptions.ResourceNotFound;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository repository;

    CustomerService(CustomerRepository customerRepository) {
        this.repository = customerRepository;
    }

    public ResponseEntity<CustomerResponseDTO> signIn(com.app.backend.customer.dto.CreateCustomerDTO createCustomerDTO) {
        Customer customer = this.repository.findByEmail(createCustomerDTO.getEmail());
        if (customer != null) {
            throw new UserIsAlreadyRegistered("User with email: " + createCustomerDTO.getEmail() + " is already registered");
        }
        Customer user = this.repository.save(createCustomerDTO.toEntity());
        return ResponseEntity.status(HttpStatus.CREATED).body(CustomerResponseDTO.toDTO(user));
    }

    public ResponseEntity<CustomerResponseDTO> getById(UUID id) {
        Customer user = this.repository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("User with email: " + id + " not found"));
        CustomerResponseDTO customerResponseDTO = CustomerResponseDTO.toDTO(user);
        return ResponseEntity.ok().body(customerResponseDTO);
    }

}
