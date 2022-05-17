package com.appgate.prueba.exceptions;

public class ConsultTimeZoneException extends AssertionError {

    public static final String MSGCONSTIZONEXCP = "La funcion consultar informacion de la zona horaria esta fallando";
    public ConsultTimeZoneException(String message, Throwable cause) {
        super(message, cause);
    }
}
