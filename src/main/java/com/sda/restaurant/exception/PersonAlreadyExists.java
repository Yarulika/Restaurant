package com.sda.restaurant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason="Person already exists")
public class PersonAlreadyExists extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PersonAlreadyExists(String msg) {super(msg); }
}
