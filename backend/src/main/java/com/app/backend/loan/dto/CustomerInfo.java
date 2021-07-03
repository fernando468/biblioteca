package com.app.backend.loan.dto;

import java.util.UUID;

import com.app.backend.customer.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerInfo {
    private UUID id;
    private String name;
    private String cpf;

    public static CustomerInfo toDTO(Customer customer) {
        return new CustomerInfo(customer.getId(), customer.getName(), customer.getCpf());
    }
}
