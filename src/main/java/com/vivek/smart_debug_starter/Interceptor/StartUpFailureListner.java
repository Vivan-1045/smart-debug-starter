package com.vivek.smart_debug_starter.Interceptor;

import com.vivek.smart_debug_starter.Analyzer.DebugAnalyser;
import com.vivek.smart_debug_starter.ConsoleFormat.Format;
import com.vivek.smart_debug_starter.Model.DebugReport;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;

public class StartUpFailureListner implements ApplicationListener<ApplicationFailedEvent> {


    @Override
    public void onApplicationEvent(ApplicationFailedEvent event) {
        Throwable ex = event.getException();
        DebugReport dbR = DebugAnalyser.analyze(ex);
        Format.print(dbR);
    }
}
