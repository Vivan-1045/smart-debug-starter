package com.vivek.smart_debug_starter.config;

import org.springframework.context.ApplicationContext;

public class SmartDebugConfig {
    private static String basePackge;

    public static void initialize(ApplicationContext appContext){
        try {
            String mainClass = appContext.getEnvironment().getProperty("spring.main.sources");

            if (mainClass != null && mainClass.contains(".")){
                basePackge = mainClass.substring(0,mainClass.lastIndexOf("."));
            }
        }catch (Exception e){
            basePackge = null;
        }
    }

    public static String getBasePackge(){
        return basePackge;
    }
}
