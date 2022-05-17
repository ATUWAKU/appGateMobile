package com.appgate.prueba.exceptions;

public class RestartException extends AssertionError {
    public static final String MSGRESTEXCEP = "La funcion reiniciar esta fallando";
    public RestartException(String message, Throwable cause) {
        super(message, cause);
    }
}
