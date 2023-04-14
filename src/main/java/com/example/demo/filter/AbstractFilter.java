package com.example.demo.filter;

import com.example.demo.domain.*;
import lombok.extern.slf4j.*;
import lombok.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

@Slf4j
public abstract class AbstractFilter implements Filter {

    public abstract boolean shouldFilter(HttpServletRequest req);

    public abstract boolean filter(HttpServletRequest req, HttpServletResponse res);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        val httpReq = new HttpRequestExtended(request);
        val httpRes = (HttpServletResponse) response;

        if (shouldFilter(httpReq)) {
            if (!filter(httpReq, httpRes)) {
                log.info("Request with URI {} doesn't pass the filter", httpReq.getRequestURI());
                return;
            }
        }

        chain.doFilter(httpReq, httpRes);
    }
}
