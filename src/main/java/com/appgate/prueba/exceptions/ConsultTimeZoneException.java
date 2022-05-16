package com.appgate.prueba.exceptions;

public class ConsultTimeZoneException extends AssertionError {

    private static final String MSG = "La función consultar información de la zona horaria está fallando";
    public ConsultTimeZoneException() {
        super(MSG);
    }
}
