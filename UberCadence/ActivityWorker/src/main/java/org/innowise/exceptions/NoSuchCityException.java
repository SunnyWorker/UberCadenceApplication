package org.innowise.exceptions;

public class NoSuchCityException extends RuntimeException {
    public NoSuchCityException(String message) {
        super(message);
    }
}
