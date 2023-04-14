package com.example.demo.filter;

import lombok.extern.slf4j.*;
import org.springframework.stereotype.*;

import javax.servlet.*;
import java.io.*;

@Slf4j
@Component
public class BasicLogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("We got req: {}, {}", request, response);

        chain.doFilter(request, response);
    }

}
