package com.app.backend.loan;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import com.app.backend.loan.dto.CreateLoanDTO;
import com.app.backend.loan.dto.LoanResponseDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/loans")
public class LoanController {
    private final LoanService service;

    LoanController(LoanService service) {
        this.service = service;
    }

    @PostMapping("/userId/{userId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<LoanResponseDTO> create(@Valid @RequestBody CreateLoanDTO createLoanDTO, @PathVariable UUID userId) {
        return this.service.create(createLoanDTO, userId);
    }

    @GetMapping("/customer/{id}/status/{status}")
    public ResponseEntity<List<LoanResponseDTO>> getAllByIdAndStatus(@PathVariable UUID id, @PathVariable String status) {
        return this.service.getAllByIdAndStatus(id, status);
    }

    @GetMapping("/customer/cpf/{cpf}")
    public ResponseEntity<List<LoanResponseDTO>> getAllByCpf(
            @PathVariable String cpf,
            @RequestParam(value = "status", required = false, defaultValue = "") String status
    ) {
        return this.service.getAllByCpf(cpf, status);
    }

    @PutMapping("/change-status/{id}/status/{status}")
    public ResponseEntity<LoanResponseDTO> changeStatus(@PathVariable UUID id, @PathVariable String status) {
        return this.service.changeStatus(id, status);
    }

    @GetMapping("/status-list")
    public ResponseEntity<List<Map<Object, Object>>> getAllStatus() {
        return this.service.getAllStatus();
    }

}
