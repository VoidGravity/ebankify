package org.example.demo9.mapper;

import org.example.demo9.dto.TransactionDTO;
import org.example.demo9.model.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    @Mapping(source = "sourceAccount.id", target = "sourceAccountId")
    @Mapping(source = "destinationAccount.id", target = "destinationAccountId")
    TransactionDTO toDTO(Transaction transaction);

    @Mapping(target = "sourceAccount.id", source = "sourceAccountId")
    @Mapping(target = "destinationAccount.id", source = "destinationAccountId")
    Transaction toEntity(TransactionDTO transactionDTO);
}

// damain -> enum TransactionStatus