package ru.mtuci.bi.lab2_3.exception;

public class ClientArgumentException extends IllegalArgumentException {

    public ClientArgumentException(String message) {
        super(message);
    }

    public ClientArgumentException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
