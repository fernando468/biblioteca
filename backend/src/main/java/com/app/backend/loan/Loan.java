package com.app.backend.loan;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.app.backend.book.Book;
import com.app.backend.customer.Customer;
import com.app.backend.library.Library;
import com.app.backend.shared.models.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Loan extends BaseEntity {
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private LocalDate scheduledDate;
    private Status status;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Book book;
    @ManyToOne
    private Library library;

    public Loan(Status status, LocalDate scheduledDate, Customer customer, Book book, Library library) {
        this.status = status;
        this.scheduledDate = scheduledDate;
        this.customer = customer;
        this.book = book;
        this.library = library;
    }
}
