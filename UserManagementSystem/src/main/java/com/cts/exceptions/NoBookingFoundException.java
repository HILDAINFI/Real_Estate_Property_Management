package com.cts.exceptions;


public class NoBookingFoundException extends RuntimeException {
    public NoBookingFoundException(String message) {
        super(message);
    }

    public NoBookingFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
