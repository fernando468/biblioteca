package com.app.backend.customer.dto;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.app.backend.customer.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDTO {
    private UUID id;
    private String name;
    private String email;
    private String phone;
    private String cpf;
    private List<CustomerLoanResponseDTO> loans;

    public static CustomerResponseDTO toDTO(Customer customer) {
        List<CustomerLoanResponseDTO> loansDTO = customer.getLoans().stream()
                .map(CustomerLoanResponseDTO::toDTO).collect(Collectors.toList());
        return new CustomerResponseDTO(
                customer.getId(),
                customer.getName(),
                customer.getEmail(),
                customer.getPhone(),
                customer.getCpf(),
                loansDTO
        );
    }
}