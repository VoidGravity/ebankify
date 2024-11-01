package org.example.demo9.dto;


import lombok.Data;
import lombok.Builder;
import org.example.demo9.model.TransactionStatus;
import org.example.demo9.model.TransactionType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class TransactionDTO {
    private Long id;

    @NotNull
    private Long sourceAccountId;

    @NotNull
    private Long destinationAccountId;

    @NotNull
    @Positive
    private BigDecimal amount;

    private LocalDateTime timestamp;
    private TransactionType type;
    private TransactionStatus status;
    private String description;
}