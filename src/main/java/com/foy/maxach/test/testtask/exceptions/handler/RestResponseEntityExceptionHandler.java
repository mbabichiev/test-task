package com.foy.maxach.test.testtask.exceptions.handler;

import com.foy.maxach.test.testtask.exceptions.UserNotFoundException;
import com.foy.maxach.test.testtask.exceptions.model.ApiExceptionModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ApiExceptionModel handleUserNotFoundException(RuntimeException exception, WebRequest request) {
        return new ApiExceptionModel(exception.getMessage(), LocalDateTime.now(),
                ((ServletWebRequest) request).getRequest().getRequestURI());
    }
}
