package com.app.backend.loan;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import com.app.backend.loan.dto.CreateLoanDTO;
import com.app.backend.loan.dto.LoanResponseDTO;
import com.app.backend.shared.exceptions.ResourceNotFound;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoanService {
    private final LoanRepository repository;

    LoanService(LoanRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<LoanResponseDTO> create(CreateLoanDTO createLoanDTO, UUID userId) {
        createLoanDTO.setCustomerId(userId);
        Loan loan = this.repository.save(createLoanDTO.toEntity());
        return ResponseEntity.status(HttpStatus.CREATED).body(LoanResponseDTO.toDTO(loan));
    }

    public ResponseEntity<List<LoanResponseDTO>> getAllByCpf(String cpf, String status) {
        List<LoanResponseDTO> loansDTO;
        if (status.isEmpty()) {
            loansDTO = this.repository.findAllByCustomerCpf(cpf).stream().map(LoanResponseDTO::toDTO)
                    .collect(Collectors.toList());
            return ResponseEntity.ok().body(loansDTO);
        }
        loansDTO = this.repository.findAllByStatusIsAndCustomerCpf(Status.valueOf(status), cpf).stream()
                .map(LoanResponseDTO::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok().body(loansDTO);
    }

    public ResponseEntity<List<LoanResponseDTO>> getAllByIdAndStatus(UUID id, String status) {
        List<LoanResponseDTO> loansDTO = this.repository.findAllByStatusIsAndCustomerId(Status.valueOf(status), id)
                .stream().map(LoanResponseDTO::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok().body(loansDTO);
    }

    private ResponseEntity<Loan> getById(UUID id) {
        Loan loan = this.repository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Loan with id: " + id + " not found!"));
        return ResponseEntity.ok().body(loan);
    }

    public ResponseEntity<List<Map<Object, Object>>> getAllStatus() {
        List<Map<Object, Object>> statusList = Arrays.stream(Status.values()).map(status -> {
            Map<Object, Object> map = new HashMap<>();
            map.put("label", status.getValue());
            map.put("value", status);
            return map;
        }).collect(Collectors.toList());
        return ResponseEntity.ok().body(statusList);
    }

    public ResponseEntity<LoanResponseDTO> changeStatus(UUID id, String status) {
        int enumOrdinal = Status.valueOf(status).ordinal();
        Loan loan = this.getById(id).getBody();
        if (status.equals("FINALIZADO") && loan.getDateStart() == null) {
            this.repository.updateStatusLoan(enumOrdinal, id, LocalDate.now(), LocalDate.now());
        }
        if (status.equals("FINALIZADO") && loan.getDateStart() != null) {
            this.repository.updateStatusLoan(enumOrdinal, id, loan.getDateStart(), loan.getDateEnd());
        }
        if (status.equals("PENDENTE")) {
            this.repository.updateStatusLoan(enumOrdinal, id, LocalDate.now(), LocalDate.now().plusDays(7));
        }
        return ResponseEntity.ok().body(LoanResponseDTO.toDTO(loan));
    }
}
