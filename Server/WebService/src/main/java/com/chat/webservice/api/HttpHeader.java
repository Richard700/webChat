package com.chat.webservice.api;

/**
 * Created by vlad
 * Date: 05.06.15_14:05
 */
public enum HttpHeader {

    TOKEN("X-Auth-Token");

    private final String header;

    HttpHeader(String header) {
        this.header = header;
    }

    public String getHeader() {
        return header;
    }
}
