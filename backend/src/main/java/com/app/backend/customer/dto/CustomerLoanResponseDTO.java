package com.app.backend.customer.dto;

import java.util.UUID;

import com.app.backend.loan.Loan;
import com.app.backend.shared.utils.DateUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerLoanResponseDTO {
    private UUID id;
    private String dateStart;
    private String dateEnd;
    private String status;

    public static com.app.backend.customer.dto.CustomerLoanResponseDTO toDTO(Loan loan) {
        return new com.app.backend.customer.dto.CustomerLoanResponseDTO(
                loan.getId(),
                DateUtil.formatToDDMMYYYY(loan.getDateStart()),
                DateUtil.formatToDDMMYYYY(loan.getDateEnd()),
                loan.getStatus().getValue()
        );
    }
}
