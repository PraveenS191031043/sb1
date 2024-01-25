package com.kgisl.sb1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;


import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class LoggingInterceptor implements HandlerInterceptor {
    
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String logFilePath = "logs/" + Instant.now().toEpochMilli() + "-sb1.log";
        try {
            Files.createFile(Paths.get(logFilePath));
        } catch (IOException e) {
            logger.error("Failed to create log file", e);
        }
        
        logger.info("State: before request reaches controller");
        logger.trace("State: trace");
        logger.debug("State: debug");
        logger.info("State: info");
        logger.warn("State: warn");
        logger.error("State: error");
        
        return true;
    }
}