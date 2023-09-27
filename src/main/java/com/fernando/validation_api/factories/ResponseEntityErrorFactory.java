package com.fernando.validation_api.factories;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.fernando.validation_api.dtos.responses.ResponseError;

public abstract class ResponseEntityErrorFactory {
    public static ResponseEntity<Object> withBadRequest(String message) {
        ResponseError responseError = new ResponseError(message, HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.badRequest().body(responseError);
    }
}