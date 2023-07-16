package com.taslim.tms.exception;

public class EmailPasswordNotMatchException extends RuntimeException{
    public EmailPasswordNotMatchException(String message){
        super(message);
    }
}