package com.chat.webservice.handler;

import com.chat.webservice.exception.ServiceRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by vlad
 * Date: 06.05.15_11:20
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ServiceRuntimeException.class)
    @ResponseBody
    public ErrorResponseI handleError(HttpServletRequest req, HttpServletResponse res, ServiceRuntimeException e) {
        res.setStatus(e.getCode());
        return new ErrorResponse(HttpStatus.valueOf(e.getCode()).value(), req.getRequestURI(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorResponseI handleError(HttpServletRequest req, Exception e) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), req.getRequestURI(), e.getMessage());
    }

}
