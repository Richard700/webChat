package com.chat.webservice.exception;

/**
 * Created by vlad
 * Date: 05.06.15_17:19
 */
public enum TypeException {

    INCORRECT_LOGIN(0),
    EXECUTE_IMPOSSIBLE(1);

    private final int code;

    TypeException(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
