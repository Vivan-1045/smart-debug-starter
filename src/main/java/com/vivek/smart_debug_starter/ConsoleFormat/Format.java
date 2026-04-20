package com.vivek.smart_debug_starter.ConsoleFormat;

import com.vivek.smart_debug_starter.Model.DebugReport;

import java.time.LocalTime;

public class Format {
    public static void print(DebugReport r){
        LocalTime lt = LocalTime.now();
        System.out.println("         ---------------------------------------------------------------------");
        System.out.println("                                  SMART DEBUG REPORT                           ");
        System.out.println("         ---------------------------------------------------------------------");

        System.out.println("         "+"["+lt.getHour()+":"+lt.getMinute()+":"+lt.getSecond()+"] "+"Root Cause: " + r.getRootException());
        System.out.println("         "+"["+lt.getHour()+":"+lt.getMinute()+":"+lt.getSecond()+"] "+"Message: " + r.getMessage());

        if (r.getFileName() != null) {
            System.out.println("         "+"["+lt.getHour()+":"+lt.getMinute()+":"+lt.getSecond()+"] "+"Location: " +
                    r.getFileName() + ":" + r.getLineNumber());
        } else {
            System.out.println("         Location: Not found (no user code)");
        }
        System.out.println();
        if (r.getFlow() != null && !r.getFlow().isEmpty()){
            System.out.println("         "+"["+lt.getHour()+":"+lt.getMinute()+":"+lt.getSecond()+"] "+"Flow ");
            for (String step : r.getFlow()) {
                System.out.println("                   -> " + step);
            }
        }
        System.out.println();
        if (r.getExceptionChain() != null) {
            System.out.println("         "+"["+lt.getHour()+":"+lt.getMinute()+":"+lt.getSecond()+"] "+"Exception Chain : " +
                    String.join(" -> ", r.getExceptionChain()));
        }

        System.out.println();

        System.out.print("         "+"["+lt.getHour()+":"+lt.getMinute()+":"+lt.getSecond()+"] "+"Suggestions : ");
        if (r.getSuggestions() != null){
            System.out.println(r.getSuggestions());
        }

        System.out.println("         ---------------------------------------------------------------------\n");

    }
}
