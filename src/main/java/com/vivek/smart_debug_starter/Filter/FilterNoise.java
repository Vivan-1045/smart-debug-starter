package com.vivek.smart_debug_starter.Filter;

public class FilterNoise {
    public static StackTraceElement findUserCode(StackTraceElement[] st){
        for (StackTraceElement el : st){
            String className = el.getClassName();

            if (!className.startsWith("org.springframework") && !className.startsWith("java") && !className.startsWith("sun")){
                return el;
            }
        }

        return null;
    }
}
