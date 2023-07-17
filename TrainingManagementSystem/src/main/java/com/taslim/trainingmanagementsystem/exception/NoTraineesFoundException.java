package com.taslim.trainingmanagementsystem.exception;

public class NoTraineesFoundException extends RuntimeException{
    public NoTraineesFoundException(String message){
        super(message);
    }
}