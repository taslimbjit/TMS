package com.taslim.onlinelibrary.controllers;

import com.taslim.tms.exception.UserAlreadyExistException;
import com.taslim.tms.exception.EmailPasswordNotMatchException;
import com.taslim.onlinelibrary.exception.BookNameAuthorNameAlreadyExistsExcepion;
import com.taslim.onlinelibrary.exception.NoBooksFoundException;
import com.taslim.onlinelibrary.model.ExceptionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({UserAlreadyExistException.class, EmailPasswordNotMatchException.class, BookNameAuthorNameAlreadyExistsExcepion.class, NoBooksFoundException.class})
    public ResponseEntity<Object> returnNotFoundException(Exception ex) {
        if (ex instanceof com.taslim.tms.exception.UserAlreadyExistException) {
            return new ResponseEntity<>(new ExceptionModel(ex.getMessage()), HttpStatus.NOT_IMPLEMENTED);
        } else if (ex instanceof com.taslim.tms.exception.EmailPasswordNotMatchException) {
            return new ResponseEntity<>(new ExceptionModel(ex.getMessage()), HttpStatus.NOT_FOUND);
        } else if (ex instanceof BookNameAuthorNameAlreadyExistsExcepion) {
            return new ResponseEntity<>(new ExceptionModel(ex.getMessage()), HttpStatus.BAD_REQUEST);
        } else if (ex instanceof NoBooksFoundException) {
            return new ResponseEntity<>(new ExceptionModel(ex.getMessage()), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(new ExceptionModel(ex.getMessage()), HttpStatus.NOT_IMPLEMENTED);
        }
    }
}
