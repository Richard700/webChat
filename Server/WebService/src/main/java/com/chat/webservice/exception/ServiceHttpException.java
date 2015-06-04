package com.chat.webservice.exception;

/**
 * Created by vlad
 * Date: 04.06.15_10:38
 */
public class ServiceHttpException extends Exception {

    private int code;

    public ServiceHttpException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
