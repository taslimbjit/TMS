package com.taslim.trainingmanagementsystem.exception;

public class NoBooksFoundException extends RuntimeException{
    public NoBooksFoundException(String message){
        super(message);
    }
}