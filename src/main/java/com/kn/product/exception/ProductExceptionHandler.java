package com.kn.product.exception;

import com.kn.product.util.CustomErrorType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<CustomErrorType> productNotFoundException(Exception e) {
        return new ResponseEntity<>(new CustomErrorType(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductException.class)
    public ResponseEntity<CustomErrorType> productException(Exception e) {
        return new ResponseEntity<>(new CustomErrorType(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<CustomErrorType> nullException(Exception e) {
        return new ResponseEntity<>(new CustomErrorType(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
