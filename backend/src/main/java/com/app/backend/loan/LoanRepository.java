package com.app.backend.loan;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, UUID> {
    @Transactional
    @Query(nativeQuery = true, value = "" +
            "UPDATE loan " +
            "SET status = :status, " +
            "date_start =:dateStart, " +
            "date_end = :dateEnd " +
            "WHERE id = :id" +
            "")
    @Modifying
    void updateStatusLoan(int status, UUID id, LocalDate dateStart, LocalDate dateEnd);

    List<Loan> findAllByStatusIsAndCustomerCpf(Status status, String cpf);

    List<Loan> findAllByCustomerCpf(String String);

    List<Loan> findAllByStatusIsAndCustomerId(Status status, UUID id);

}
