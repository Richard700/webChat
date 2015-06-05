package com.chat.webservice.exception;

/**
 * Created by vlad
 * Date: 05.06.15_17:12
 */
public class ChatServiceException extends Exception {

    private TypeException typeException;

    public ChatServiceException(String message, TypeException typeException) {
        super(message);
        this.typeException = typeException;
    }

    public TypeException getTypeException() {
        return typeException;
    }
}
