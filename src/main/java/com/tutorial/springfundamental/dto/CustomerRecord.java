package com.tutorial.springfundamental.dto;

import com.tutorial.springfundamental.constants.RegExConstants;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public record CustomerRecord(
        @NotNull
        String username,
        @NotNull
        @Pattern(regexp = RegExConstants.PASSWORD_REGEX)
        String password,
        @Email
        String email,
        String dateOfBirth) {
}
