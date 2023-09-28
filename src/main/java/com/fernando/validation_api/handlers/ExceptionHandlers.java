package com.fernando.validation_api.handlers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.fernando.validation_api.exceptions.RequestBodyException;
import com.fernando.validation_api.factories.ResponseEntityErrorFactory;

@RestControllerAdvice
public class ExceptionHandlers extends ResponseEntityExceptionHandler {
    @Override
    @Nullable
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e,
            HttpHeaders headers, HttpStatusCode status, 
            WebRequest request) {
                FieldError fieldError = e.getFieldError();
        String errorMessage = fieldError != null ? fieldError.getDefaultMessage() : "";
        return ResponseEntityErrorFactory.withBadRequest(errorMessage);
    }

    
    @ExceptionHandler(RequestBodyException.class)
    public ResponseEntity<Object> handleRequestBody(RequestBodyException e) {
        String errorMessage = e.getMessage();
        return ResponseEntityErrorFactory.withBadRequest(errorMessage);
    }


    @Override
    @Nullable
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException e, HttpHeaders headers,
            HttpStatusCode status, WebRequest request) {
                String endpointUrl = e.getRequestURL();
                return ResponseEntityErrorFactory.withNotFound(endpointUrl);
    }

    

    
    





}
