package org.example.demo9.repository;

import org.example.demo9.model.BankAccount;
import org.example.demo9.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findBySourceAccountOrDestinationAccount(BankAccount sourceAccount, BankAccount destAccount);
}