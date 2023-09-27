package com.fernando.validation_api.dtos.requests;

import org.hibernate.validator.constraints.br.CPF;
import jakarta.validation.constraints.NotNull;

public record ValidateCpfDTO(
    @NotNull(message = "CPF value doesn't found")
    @CPF(message = "CPF doesn't valid") 
String cpf) {}