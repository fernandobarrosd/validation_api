package com.fernando.validation_api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class RequestBodyException extends RuntimeException {
    public RequestBodyException(String message) {
        super(message);
    }
}
