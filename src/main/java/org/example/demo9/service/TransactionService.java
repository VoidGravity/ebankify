package org.example.demo9.service;

import org.example.demo9.dto.TransactionDTO;
import org.example.demo9.mapper.TransactionMapper;
import org.example.demo9.model.BankAccount;
import org.example.demo9.model.Transaction;
import org.example.demo9.model.TransactionStatus;
import org.example.demo9.repository.BankAccountRepository;
import org.example.demo9.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final BankAccountRepository bankAccountRepository;
    private final TransactionMapper transactionMapper;

    public TransactionDTO createTransaction(TransactionDTO transactionDTO) {
        BankAccount sourceAccount = bankAccountRepository.findById(transactionDTO.getSourceAccountId())
                .orElseThrow(() -> new RuntimeException("Source account not found"));

        BankAccount destAccount = bankAccountRepository.findById(transactionDTO.getDestinationAccountId())
                .orElseThrow(() -> new RuntimeException("Destination account not found"));

        if (sourceAccount.getBalance().compareTo(transactionDTO.getAmount()) < 0) {
            throw new RuntimeException("Insufficient funds");
        }

        Transaction transaction = transactionMapper.toEntity(transactionDTO);
        transaction.setSourceAccount(sourceAccount);
        transaction.setDestinationAccount(destAccount);
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setStatus(TransactionStatus.COMPLETED);

        sourceAccount.setBalance(sourceAccount.getBalance().subtract(transactionDTO.getAmount()));
        destAccount.setBalance(destAccount.getBalance().add(transactionDTO.getAmount()));

        bankAccountRepository.save(sourceAccount);
        bankAccountRepository.save(destAccount);
        transaction = transactionRepository.save(transaction);

        return transactionMapper.toDTO(transaction);
    }

    public List<TransactionDTO> getTransactionsByAccountId(Long accountId) {
        BankAccount account = bankAccountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        return transactionRepository.findBySourceAccountOrDestinationAccount(account, account).stream()
                .map(transactionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TransactionDTO getTransactionById(Long id) {
        return transactionRepository.findById(id)
                .map(transactionMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
    }
}