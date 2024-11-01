package org.example.demo9.service;

import org.springframework.stereotype.Service;



import org.example.demo9.dto.BankAccountDTO;
import org.example.demo9.mapper.BankAccountMapper;
import org.example.demo9.model.BankAccount;
import org.example.demo9.model.User;
import org.example.demo9.repository.BankAccountRepository;
import org.example.demo9.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class BankAccountService {
    private final BankAccountRepository bankAccountRepository;
    private final UserRepository userRepository;
    private final BankAccountMapper bankAccountMapper;

    public BankAccountDTO createAccount(BankAccountDTO accountDTO) {
        User owner = userRepository.findById(accountDTO.getOwnerId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        BankAccount account = bankAccountMapper.toEntity(accountDTO);
        account.setOwner(owner);
        account = bankAccountRepository.save(account);
        return bankAccountMapper.toDTO(account);
    }

    public List<BankAccountDTO> getAccountsByUserId(Long userId) {
        User owner = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return bankAccountRepository.findByOwner(owner).stream()
                .map(bankAccountMapper::toDTO)
                .collect(Collectors.toList());
    }

    public BankAccountDTO getAccountById(Long id) {
        return bankAccountRepository.findById(id)
                .map(bankAccountMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public void deleteAccount(Long id) {
        bankAccountRepository.deleteById(id);
    }
}