package org.example.demo9.mapper;


import org.example.demo9.dto.UserDTO;
import org.example.demo9.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface UserMapper {
    UserDTO toDTO(User user);
    User toEntity(UserDTO userDTO);
}