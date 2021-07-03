package com.app.backend.loan.dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.app.backend.book.Book;
import com.app.backend.customer.Customer;
import com.app.backend.library.Library;
import com.app.backend.loan.Loan;
import com.app.backend.loan.Status;
import com.app.backend.shared.utils.DateUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateLoanDTO {
    @NotNull(message = "Scheduled Date is required")
    private String scheduledDate;

    private UUID customerId;

    @NotBlank(message = "LibraryId is required")
    private String libraryId;

    @NotBlank(message = "BookId is required")
    private String bookId;

    public Loan toEntity() {
        Customer customer = new Customer();
        customer.setId(customerId);
        Book book = new Book();
        book.setId(UUID.fromString(bookId));
        Library library = new Library();
        library.setId(UUID.fromString(libraryId));
        return new Loan(
                Status.PENDENTE,
                DateUtil.formatToLocalDate(scheduledDate),
                customer,
                book,
                library
        );
    }
}
