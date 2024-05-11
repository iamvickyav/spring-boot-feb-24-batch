package com.centralibrary.librarymanager.exception;

public class BusinessException extends RuntimeException {

    private final String message;

    private final int statusCode;

    public BusinessException(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public String toString() {
        return "message: " + getMessage();
    }
}
