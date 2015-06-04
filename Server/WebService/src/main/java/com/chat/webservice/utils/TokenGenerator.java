package com.chat.webservice.utils;

import java.util.UUID;

/**
 * Created by vlad
 * Date: 04.06.15_12:14
 */
public class TokenGenerator implements TokenGeneratorI {

    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
