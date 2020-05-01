package com.nopaldev.artesanos.core.exceptions;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(final String message) {
        super(message);
    }
}
