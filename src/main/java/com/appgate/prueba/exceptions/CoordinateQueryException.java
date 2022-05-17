package com.appgate.prueba.exceptions;

public class CoordinateQueryException extends AssertionError {

    public static final String MSGCOORDQUEEXCP = "Las coordenadas no pueden ser consultadas aunque el celular tenga acceso a la localizacion";

    public CoordinateQueryException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
