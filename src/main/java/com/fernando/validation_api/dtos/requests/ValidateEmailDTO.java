package com.fernando.validation_api.dtos.requests;

import com.fernando.validation_api.validations.annotations.ValidEmail;

public record ValidateEmailDTO(
    @ValidEmail(message = "Email doesn't valid") 
    String email){}