package com.fsd.customer.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomerControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value= CustomerException.class)
    protected ResponseEntity<Object> handleTemplateException(CustomerException exception){
        return new ResponseEntity<>(exception.getErrorBean(),exception.getHttpStatus());
    }
}