package com.vivek.smart_debug_starter.Filter;

import java.util.ArrayList;
import java.util.List;

public class FilterNoise {
    public static StackTraceElement findUserCode(StackTraceElement[] stackTrace) {

        for (StackTraceElement el : stackTrace) {
            String className = el.getClassName();

            if (isFrameworkClass(className)) {
                continue;
            }

            return el;
        }

        return null;
    }

    private static boolean isFrameworkClass(String className) {
        return className.startsWith("java.") ||
                className.startsWith("javax.") ||
                className.startsWith("jakarta.") ||
                className.startsWith("sun.") ||
                className.startsWith("jdk.") ||
                className.startsWith("org.springframework.") ||
                className.startsWith("org.apache.") ||
                className.contains("$$");
    }

    public static List<StackTraceElement> getExecutionFlow(StackTraceElement[]ex){
        List<StackTraceElement> flow = new ArrayList<>();

        for (StackTraceElement el : ex){
            String clName = el.getClassName();

            if (!isFrameworkClass(clName)){
                flow.add(el);
            }
        }

        return flow;
    }
}
