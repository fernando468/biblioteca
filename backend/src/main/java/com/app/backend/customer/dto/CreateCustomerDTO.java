package com.app.backend.customer.dto;

import java.util.ArrayList;
import java.util.UUID;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.app.backend.customer.Customer;
import com.app.backend.user.Password;
import com.app.backend.user.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerDTO {
    @NotBlank(message = "Name is required")
    @Size(message = "Max size: 80", max = 80)
    private String name;

    @NotBlank(message = "Email is required")
    @Email
    private String email;

    @NotBlank(message = "Password is required")
    @Size(message = "Max size: 12", max = 12)
    private String password;

    @NotBlank(message = "Phone is required")
    @Size(message = "Max size: 11", max = 11)
    private String phone;

    @NotBlank(message = "CPF is required")
    @Size(message = "Max size: 11", max = 11)
    private String cpf;

    public Customer toEntity() {
        Role role = new Role();
        role.setId(UUID.fromString("7e7f1b88-3f0b-4503-b5c4-bead1623dcaf"));
        return new Customer(
                this.name,
                this.email,
                new Password(
                        this.password
                ),
                this.phone,
                role,
                new ArrayList<>(),
                this.cpf
        );
    }
}
