package com.fernando.validation_api.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MethodNotAlowedResponseError extends ResponseError {
    private String requestMethodName;

    public MethodNotAlowedResponseError() {
        super();
    }

    public MethodNotAlowedResponseError(String message, Integer statusCode, 
    String requestMethodName) {
        super(message, statusCode);
        this.requestMethodName = requestMethodName;
    }

    

    
}
