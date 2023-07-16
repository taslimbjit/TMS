package com.taslim.trainingmanagementsystem.exception;

public class EmailPasswordNotMatchException extends RuntimeException{
    public EmailPasswordNotMatchException(String message){
        super(message);
    }
}