package com.sda.restaurant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Person not found")
public class PersonNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 4022075116501529175L;

    public PersonNotFoundException(String msg) {
        super(msg);
    }
}


