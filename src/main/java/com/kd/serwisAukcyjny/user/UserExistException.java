package com.kd.serwisAukcyjny.user;

public class UserExistException extends RuntimeException {
    public UserExistException (String message){
        super(message);
    }
}
