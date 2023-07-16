package com.taslim.tms.exception;

public class NoTrainersFoundException extends RuntimeException{
    public NoTrainersFoundException(String message){
        super(message);
    }
}
