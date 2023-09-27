package com.fernando.validation_api.dtos.requests;

import org.hibernate.validator.constraints.br.CNPJ;
import jakarta.validation.constraints.NotNull;

public record ValidateCnpjDTO(
    @NotNull(message = "CNPJ value doesn't found")
    @CNPJ(message = "CNPJ doesn't valid") 
String cnpj){}