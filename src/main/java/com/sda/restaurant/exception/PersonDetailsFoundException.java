package com.sda.restaurant.exception;

public class PersonDetailsFoundException extends RuntimeException {

    private static final long serialVersionUID = -3454869696904756444L;

    public PersonDetailsFoundException(String msg) {
        super(msg);
    }
}
