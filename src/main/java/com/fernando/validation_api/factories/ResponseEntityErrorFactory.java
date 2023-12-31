package com.fernando.validation_api.factories;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import com.fernando.enums.RequestMethod;
import com.fernando.validation_api.dtos.responses.MethodNotAlowedResponseError;
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

    public static ResponseEntity<Object> withMethodNotAlowed(
        String requestMethodName) {
        HttpStatus httpStatus = HttpStatus.METHOD_NOT_ALLOWED;

        RequestMethod requestMethod = RequestMethod.valueOf(requestMethodName);

        String message = String.format("Method %s doesn't alowed", 
        requestMethod.getValue());


        MethodNotAlowedResponseError responseError = 
        new MethodNotAlowedResponseError(message, httpStatus.value(), 
        requestMethod.getValue());

        return new ResponseEntity<>
        (responseError, HttpStatusCode.valueOf(httpStatus.value()));
    }
}