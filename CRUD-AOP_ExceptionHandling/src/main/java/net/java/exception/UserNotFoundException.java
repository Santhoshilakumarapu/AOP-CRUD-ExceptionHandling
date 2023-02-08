package net.java.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


public class UserNotFoundException extends Exception{
    public UserNotFoundException(String message) {
        super(message);
    }
}
