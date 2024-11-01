package org.example.demo9.mapper;

import org.example.demo9.dto.BankAccountDTO;
import org.example.demo9.model.BankAccount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BankAccountMapper {
    @Mapping(source = "owner.id", target = "ownerId")
    BankAccountDTO toDTO(BankAccount bankAccount);

    @Mapping(target = "owner.id", source = "ownerId")
    BankAccount toEntity(BankAccountDTO bankAccountDTO);
}