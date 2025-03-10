package com.rest.springbootemployee.advice;

import com.rest.springbootemployee.exception.InvalidIdException;
import com.rest.springbootemployee.exception.NoCompanyFoundException;
import com.rest.springbootemployee.exception.NoEmployeeFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({NoEmployeeFoundException.class, NoCompanyFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse method(Exception exception) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    }

    @ExceptionHandler(InvalidIdException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInvalidIdException(Exception exception){
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }


}
