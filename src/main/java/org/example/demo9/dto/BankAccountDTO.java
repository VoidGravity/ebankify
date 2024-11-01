package org.example.demo9.dto;


import lombok.Data;
import lombok.Builder;
import org.example.demo9.model.AccountStatus;
import org.example.demo9.model.AccountType;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
public class BankAccountDTO {
    private Long id;

    @NotBlank
    private String accountNumber;

    @NotNull
    private BigDecimal balance;

    @NotNull
    private Long ownerId;

    private AccountStatus status;
    private AccountType accountType;
}