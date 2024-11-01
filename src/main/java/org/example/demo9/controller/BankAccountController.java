package org.example.demo9.controller;


import org.example.demo9.dto.BankAccountDTO;
import org.example.demo9.service.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class BankAccountController {
    private final BankAccountService bankAccountService;

    @PostMapping
    public ResponseEntity<BankAccountDTO> createAccount(@Valid @RequestBody BankAccountDTO accountDTO) {
        return ResponseEntity.ok(bankAccountService.createAccount(accountDTO));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BankAccountDTO>> getAccountsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(bankAccountService.getAccountsByUserId(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankAccountDTO> getAccountById(@PathVariable Long id) {
        return ResponseEntity.ok(bankAccountService.getAccountById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        bankAccountService.deleteAccount(id);
        return ResponseEntity.ok().build();
    }
}