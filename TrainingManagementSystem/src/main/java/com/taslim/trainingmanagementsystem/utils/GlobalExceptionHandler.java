package com.taslim.trainingmanagementsystem.utils;

import com.taslim.trainingmanagementsystem.exception.*;
import com.taslim.trainingmanagementsystem.model.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({CourseNotFoundExcepion.class, UserAlreadyExistException.class, EmailPasswordNotMatchException.class, AssignmentNotFoundExcepion.class, NoTraineesFoundException.class})
    public ResponseEntity<Object> returnNotFoundException(Exception ex) {
        if (ex instanceof com.taslim.trainingmanagementsystem.exception.UserAlreadyExistException) {
            return new ResponseEntity<>(new ExceptionModel(ex.getMessage()), HttpStatus.NOT_IMPLEMENTED);
        } else if (ex instanceof com.taslim.trainingmanagementsystem.exception.EmailPasswordNotMatchException) {
            return new ResponseEntity<>(new ExceptionModel(ex.getMessage()), HttpStatus.NOT_FOUND);
        } else if (ex instanceof AssignmentNotFoundExcepion) {
            return new ResponseEntity<>(new ExceptionModel(ex.getMessage()), HttpStatus.BAD_REQUEST);
        }
        else if (ex instanceof CourseNotFoundExcepion) {
            return new ResponseEntity<>(new ExceptionModel(ex.getMessage()), HttpStatus.BAD_REQUEST);
        }
        else if (ex instanceof CourseNotFoundExcepion) {
            return new ResponseEntity<>(new ExceptionModel(ex.getMessage()), HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>(new ExceptionModel(ex.getMessage()), HttpStatus.NOT_IMPLEMENTED);
        }
    }
}
