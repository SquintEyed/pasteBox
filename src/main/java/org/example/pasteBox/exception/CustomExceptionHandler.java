package org.example.pasteBox.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleException(NotFoundException ex){

        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
