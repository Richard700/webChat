package com.chat.webservice.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by vlad
 * Date: 04.06.15_10:38
 */
public class ServiceHttpException extends IllegalArgumentException {

    private HttpStatus httpStatus;

    public ServiceHttpException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public int getCode() {
        return httpStatus.value();
    }
}
