package org.example.demo9.dto;

import lombok.Data;
import lombok.Builder;
import org.example.demo9.model.AccountStatus;
import org.example.demo9.model.AccountType;

import java.math.BigDecimal;

@Data
@Builder
public class BankAccountDTO {
    private Long id;
    private String accountNumber;
    private BigDecimal balance;
    private Long ownerId;  // This represents the User's ID
    private AccountStatus status;
    private AccountType accountType;
}