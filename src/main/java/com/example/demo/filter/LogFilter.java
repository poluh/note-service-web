package com.example.demo.filter;

import lombok.extern.slf4j.*;
import lombok.*;
import org.springframework.core.annotation.*;
import org.springframework.stereotype.*;

import javax.servlet.http.*;


@Slf4j
@Order(-1)
@Component
public class LogFilter extends AbstractFilter {

    @Override
    public boolean shouldFilter(HttpServletRequest req) {
        return true;
    }

    @Override
    public boolean filter(HttpServletRequest req, HttpServletResponse res) {
        val userId = req.getHeader("UserId");
        log.info("Handle request {} with userId = {}", req.getRequestURI(), userId);
        return true;
    }

}
