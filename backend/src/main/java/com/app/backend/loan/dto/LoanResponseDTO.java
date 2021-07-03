package com.app.backend.loan.dto;

import java.util.UUID;

import com.app.backend.library.dto.LibraryResponseDTO;
import com.app.backend.loan.Loan;
import com.app.backend.shared.utils.DateUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoanResponseDTO {
    private UUID id;
    private String dateStart;
    private String dateEnd;
    private String scheduledDate;
    private String status;
    private CustomerInfo customer;
    private BookInfos book;
    private LibraryResponseDTO library;

    public static LoanResponseDTO toDTO(Loan loan) {
        BookInfos book = BookInfos.toDTO(loan.getBook());
        return new LoanResponseDTO(
                loan.getId(),
                DateUtil.formatToDDMMYYYY(loan.getDateStart()),
                DateUtil.formatToDDMMYYYY(loan.getDateEnd()),
                DateUtil.formatToDDMMYYYY(loan.getScheduledDate()),
                loan.getStatus().getValue(),
                CustomerInfo.toDTO(loan.getCustomer()),
                book,
                LibraryResponseDTO.toDTO(loan.getLibrary())
        );
    }
}
