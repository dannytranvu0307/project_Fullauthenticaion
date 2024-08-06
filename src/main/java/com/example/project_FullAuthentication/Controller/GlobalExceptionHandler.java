package com.example.project_FullAuthentication.Controller;

import com.example.project_FullAuthentication.Exception.CommonException;

import com.example.project_FullAuthentication.Exception.ResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CommonException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseData handleCommonException(CommonException ex) {
        return ResponseData.builder()
                .code(ex.getError_code() == null ? "" : ex.getError_code())
                .message(ex.getError_message())
                .type(ResponseData.ResponseType.ERROR)
                .build();
    }
}
