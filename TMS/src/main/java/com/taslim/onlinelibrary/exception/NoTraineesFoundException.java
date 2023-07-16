package com.taslim.tms.exception;

public class NoTraineesFoundException extends RuntimeException{
    public NoTraineesFoundException(String message){
        super(message);
    }
}