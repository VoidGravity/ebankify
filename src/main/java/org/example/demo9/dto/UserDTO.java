package org.example.demo9.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Data;
import lombok.Builder;
import org.example.demo9.model.Role;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
public class UserDTO {
    private Long id;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Past
    private LocalDate dateOfBirth;

    private Set<Role> roles;
    private boolean enabled;
}