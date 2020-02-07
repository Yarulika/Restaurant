package com.sda.restaurant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "Person details found")
public class PersonDetailsFoundException extends RuntimeException {

    private static final long serialVersionUID = 2102189444006703817L;

    public PersonDetailsFoundException(String msg) {
        super(msg);
    }
}


