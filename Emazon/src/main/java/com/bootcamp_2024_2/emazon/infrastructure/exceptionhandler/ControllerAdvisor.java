package com.bootcamp_2024_2.emazon.infrastructure.exceptionhandler;

import com.bootcamp_2024_2.emazon.domain.model.ErrorResponse;
import com.bootcamp_2024_2.emazon.infrastructure.exception.RoleNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Collections;

import static com.bootcamp_2024_2.emazon.infrastructure.exceptionhandler.ExceptionResponse.*;

@RestControllerAdvice
public class ControllerAdvisor {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RoleNotFoundException.class)
    public ErrorResponse handleArticleNotFoundException() {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(ExceptionResponse.ROLE_NOT_FOUND.getCode());
        errorResponse.setMessage(ExceptionResponse.ROLE_NOT_FOUND.getMessage());
        errorResponse.setTimestamp(LocalDateTime.now());
        return errorResponse;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        BindingResult result  = exception.getBindingResult();
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(INVALID_ROLE.getCode());
        errorResponse.setMessage(INVALID_ROLE.getMessage());
        errorResponse.setDetails(result.getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList());
        errorResponse.setTimestamp(LocalDateTime.now());
        return errorResponse;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleGenericError(Exception exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(ExceptionResponse.GENERIC_ERROR.getCode());
        errorResponse.setMessage(ExceptionResponse.GENERIC_ERROR.getMessage());
        errorResponse.setDetails(Collections.singletonList(exception.getMessage()));
        errorResponse.setTimestamp(LocalDateTime.now());
        return errorResponse;
    }
}
