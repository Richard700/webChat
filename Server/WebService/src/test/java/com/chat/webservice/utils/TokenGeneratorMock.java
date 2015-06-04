package com.chat.webservice.utils;

/**
 * Created by vlad
 * Date: 04.06.15_12:16
 */
public class TokenGeneratorMock implements TokenGeneratorI {

    @Override
    public String generate() {
        return "token";
    }
}
