package com.chat.webservice.filter;

import com.chat.webservice.api.HttpHeader;
import com.chat.webservice.businesslayer.AuthServiceI;
import com.chat.webservice.handler.ErrorResponse;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.CompositeFilter;
import org.springframework.web.filter.RequestContextFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationFilter extends RequestContextFilter {

    public static final String URL_IGNORE = "/auth";
    public static final String ERROR_UNAUTHORIZED = "User is not authorization";

    @Autowired
    private AuthServiceI authService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String path = request.getPathInfo();

        if (checkPathIgnore(path)) {
            chain.doFilter(request, response);
            return;
        }
        String token = request.getHeader(HttpHeader.TOKEN.getHeader());
        if (!validToken(token)) {
            wrapErrorUnauthorized(request, response);
            return;
        }
        chain.doFilter(request, response);
    }

    private boolean checkPathIgnore(String path) {
        return path != null && path.startsWith(URL_IGNORE);
    }

    private boolean validToken(String token) {
        if (token == null || token.trim().isEmpty()) {
            return false;
        }
        return authService.isValidToken(token);
    }

    private void wrapErrorUnauthorized(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int httpStatus = HttpStatus.UNAUTHORIZED.value();
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(httpStatus);

        ErrorResponse errorResponse = new ErrorResponse(httpStatus, request.getPathInfo(), ERROR_UNAUTHORIZED);

        ServletOutputStream stream = response.getOutputStream();
        stream.print(convertToJson(errorResponse));
    }

    private String convertToJson(ErrorResponse response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(response);
    }
}