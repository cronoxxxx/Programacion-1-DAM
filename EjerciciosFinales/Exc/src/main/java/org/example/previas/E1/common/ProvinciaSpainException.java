package org.example.previas.E1.common;

public class ProvinciaSpainException extends Exception{
    public ProvinciaSpainException() {
        super("No es una provincia de España, intenta agregar algo razonable, anda xd");
    }

    public ProvinciaSpainException(String message) {
        super(message);
    }
}
