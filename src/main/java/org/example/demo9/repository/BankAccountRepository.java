package org.example.demo9.repository;

import org.example.demo9.model.BankAccount;
import org.example.demo9.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
    List<BankAccount> findByOwner(User owner);
    Optional<BankAccount> findByAccountNumber(String accountNumber);
}
