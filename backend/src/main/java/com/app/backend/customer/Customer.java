package com.app.backend.customer;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.app.backend.loan.Loan;
import com.app.backend.user.Password;
import com.app.backend.user.Role;
import com.app.backend.user.User;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@Entity
public class Customer extends User {
    @Column(nullable = false)
    private String cpf;

    @Column(length = 11)
    private String phone;

    @OneToMany(mappedBy = "customer")
    private List<Loan> loans;

    public Customer(String name, String email, Password password, String phone, Role role, List<Loan> loans, String cpf) {
        super(name, email, password, role);
        this.loans = loans;
        this.phone = phone;
        this.cpf = cpf;
    }
}
