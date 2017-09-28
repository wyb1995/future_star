package com.thoughtworks.futurestar.exception;

public class InvalidCredentialException extends RuntimeException {
    public InvalidCredentialException() {
    }

    public InvalidCredentialException(String msg) {
        super(msg);
    }

}
