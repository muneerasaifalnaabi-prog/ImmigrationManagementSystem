package com.example.ims.Exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ImsException.class)
    public ResponseEntity<ErrorResponse> handleImsException(
            ImsException ex, WebRequest request) {

        ErrorResponse errorResponse = new ErrorResponse(
                ex.getStatus(),
                ex.getStatus().value(),
                ex.getStatus().getReasonPhrase(),
                ex.getMessage(),
                request.getDescription(false).replace("uri=", "")
        );

        return ResponseEntity.status(ex.getStatus()).body(errorResponse);
    }
}
