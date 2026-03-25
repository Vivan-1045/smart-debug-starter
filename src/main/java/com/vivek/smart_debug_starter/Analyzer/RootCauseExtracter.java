package com.vivek.smart_debug_starter.Analyzer;

public class RootCauseExtracter {

    public static Throwable getRootCause(Throwable e){
        Throwable res = e;

        while (res.getCause() != null){
            res = res.getCause();
        }

        return res;
    }
}
