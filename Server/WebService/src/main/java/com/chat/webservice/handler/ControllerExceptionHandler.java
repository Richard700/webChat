package com.chat.webservice.handler;

import com.chat.webservice.exception.ChatServiceException;
import com.chat.webservice.exception.ServiceHttpException;
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

    @ExceptionHandler(ChatServiceException.class)
    @ResponseBody
    public ErrorResponseI handleError(HttpServletRequest req, HttpServletResponse res, ChatServiceException e) {
        HttpStatus status = getHttpStatusByTypeError(e);
        res.setStatus(status.value());
        return new ErrorResponse(status.value(), req.getRequestURI(), e.getMessage());
    }

    private HttpStatus getHttpStatusByTypeError(ChatServiceException e) {
        switch (e.getTypeException()) {
            case INCORRECT_LOGIN:
                return HttpStatus.NOT_FOUND;
            case EXECUTE_IMPOSSIBLE:
                return HttpStatus.METHOD_NOT_ALLOWED;
        }
        return HttpStatus.BAD_REQUEST;
    }

    @ExceptionHandler(ServiceHttpException.class)
    @ResponseBody
    public ErrorResponseI handleError(HttpServletRequest req, HttpServletResponse res, ServiceHttpException e) {
        res.setStatus(e.getCode());
        return new ErrorResponse(e.getCode(), req.getRequestURI(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorResponseI handleError(HttpServletRequest req, Exception e) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), req.getRequestURI(), e.getMessage());
    }

}
