package com.example.demo.domain;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class HttpRequestExtended extends HttpServletRequestWrapper {

    private final Map<String, String> internalHeaders = new HashMap<>();

    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request The request to wrap
     * @throws IllegalArgumentException if the request is null
     */
    public HttpRequestExtended(ServletRequest request) {
        super((HttpServletRequest) request);
    }

    @Override
    public String getHeader(String name) {
        if (internalHeaders.containsKey(name)) {
            return internalHeaders.get(name);
        }
        return super.getHeader(name);
    }
}
