package com.tutorial.springfundamental.dto;

import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.UUID;

public record CustomerRecord(
        @UUID
        String username,
        @Pattern(regexp = "(?=[A-Za-z\\d@#$%^&+!=]+$)^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+!=])([A-Za-z\\d@$!%*?&]{8,24}$)")
        String password,
        String email,
        String dateOfBirth) {
}
