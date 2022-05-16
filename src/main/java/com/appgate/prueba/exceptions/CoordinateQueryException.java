package com.appgate.prueba.exceptions;

public class CoordinateQueryException extends AssertionError {

    private static final String MSG = "Las coordenadas no pueden ser consultadas aunque el celular tenga acceso a la localización";

    public CoordinateQueryException() {
        super(MSG);
    }
}
