package com.gtu.EngBook.controller;

import ch.qos.logback.core.encoder.EchoEncoder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public void temp(){}
}
