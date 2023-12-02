package com.monteiro.enzo.ngosync.services.exceptions;

public class EntityUnprocessableException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    public EntityUnprocessableException(String msg){super(msg);}
}
