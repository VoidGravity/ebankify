package org.example.demo9.mapper;

import org.example.demo9.model.Transaction;
import org.example.demo9.model.TransactionDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface TransactionDocumentMapper {

    @Mapping(target = "sourceAccountId", source = "sourceAccount.id")
    @Mapping(target = "destinationAccountId", source = "destinationAccount.id")
    @Mapping(target = "type", source = "type")
    @Mapping(target = "status", source = "status")
    TransactionDocument toDocument(Transaction transaction);

    @Mapping(target = "sourceAccount.id", source = "sourceAccountId")
    @Mapping(target = "destinationAccount.id", source = "destinationAccountId")
    @Mapping(target = "type", source = "type")
    @Mapping(target = "status", source = "status")
    Transaction toEntity(TransactionDocument document);
}