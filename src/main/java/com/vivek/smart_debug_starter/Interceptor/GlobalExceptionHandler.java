package com.vivek.smart_debug_starter.Interceptor;

import com.vivek.smart_debug_starter.Analyzer.DebugAnalyser;
import com.vivek.smart_debug_starter.ConsoleFormat.Format;
import com.vivek.smart_debug_starter.Model.DebugReport;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public void handle(Exception e){
        DebugReport dbR = DebugAnalyser.analyze(e);
        Format.print(dbR);
    }
}
