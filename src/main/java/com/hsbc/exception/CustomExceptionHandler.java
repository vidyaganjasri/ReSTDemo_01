package com.hsbc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> meth1(InvalidIdException e){
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND,e.getMessage());
        ResponseEntity<ErrorResponse> responseEntity = new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
        return responseEntity;
    }
}
