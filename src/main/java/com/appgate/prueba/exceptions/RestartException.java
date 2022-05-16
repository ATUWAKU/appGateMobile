package com.appgate.prueba.exceptions;

public class RestartException extends AssertionError {
    private static final String MSG = "La función reiniciar está fallando";
    public RestartException() {
        super(MSG);
    }
}
