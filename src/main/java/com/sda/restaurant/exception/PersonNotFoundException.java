package com.sda.restaurant.exception;

public class PersonNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 4022075116501529175L;

    public PersonNotFoundException(String msg) {
        super(msg);

    }
}
