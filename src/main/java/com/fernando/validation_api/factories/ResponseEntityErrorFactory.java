package com.fernando.validation_api.factories;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import com.fernando.validation_api.dtos.responses.ResponseError;

public abstract class ResponseEntityErrorFactory {
    public static ResponseEntity<Object> withBadRequest(String message) {
        ResponseError responseError = new ResponseError(message, HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.badRequest().body(responseError);
    }

    public static ResponseEntity<Object> withNotFound(String endpoint) {
        String message = String.format("%s endpoint doesn't found", endpoint);
        ResponseError responseError = new ResponseError(message, HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(responseError, HttpStatusCode.valueOf(HttpStatus.NOT_FOUND.value()));
    }
}