package com.kata.bank.data.repository;

import com.kata.bank.data.model.Account;
import com.kata.bank.data.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
    @Query("SELECT o FROM Operation o WHERE o.account.accountNumber = ?1")
    List<Operation> findOperationsByAccountNumber(String accountNumber);
}
