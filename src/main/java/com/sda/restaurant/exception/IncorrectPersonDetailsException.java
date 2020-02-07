package com.sda.restaurant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class IncorrectPersonDetailsException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private BindingResult bindingResult;

    public IncorrectPersonDetailsException(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }

    @Override
    public String getMessage() {
        String msg = "Person has incorrect details";
        List<ObjectError> errors = bindingResult.getAllErrors();
        for (ObjectError er: errors){
            msg = msg + " " + er.getDefaultMessage();
        }
        return msg;
    }

}
