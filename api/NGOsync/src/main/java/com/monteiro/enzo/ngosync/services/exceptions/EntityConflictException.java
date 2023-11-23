package com.monteiro.enzo.ngosync.services.exceptions;

public class EntityConflictException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public EntityConflictException(String msg){ super(msg);}

}