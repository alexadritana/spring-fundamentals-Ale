package com.espe.springfundamentalsale.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

    private static final Logger log =
            LoggerFactory.getLogger(LoggingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) {
        log.info("[PRE] {} {}", request.getMethod(), request.getRequestURI());
        request.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) {
        log.info("[POST] Status: {}", response.getStatus());
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex) {
        long start = (Long) request.getAttribute("startTime");
        long duration = System.currentTimeMillis() - start;
        log.info("[DONE] Completed in {} ms", duration);
    }
}