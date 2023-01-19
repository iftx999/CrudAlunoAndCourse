package com.loiane.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public record AlunoDTO(
        @JsonProperty("_id") Long id,
        @NotBlank @NotNull @Length(min = 5, max = 100) String nome,
        @NotBlank @NotNull @Length(min = 5, max = 100) Integer idade,
        @NotNull @Length(max = 10) @Pattern(regexp = "Back-end|Front-end") String cpf) {
}