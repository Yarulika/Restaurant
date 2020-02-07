package com.sda.restaurant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//TODO: will check options, maybe no need in this class at all
//@ControllerAdvice for many @ExceptionHandler
// class ExceptionHandler extends ResponseEntityExceptionHandler
@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(PersonDetailsFoundException.class)
    public void handleEmailFoundException(PersonDetailsFoundException exception, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }

    @ExceptionHandler(PersonNotFoundException.class)
    public void handlePersonNotFoundException(PersonNotFoundException exception, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    }

}
