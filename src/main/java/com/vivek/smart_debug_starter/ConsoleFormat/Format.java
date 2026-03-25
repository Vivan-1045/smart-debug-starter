package com.vivek.smart_debug_starter.ConsoleFormat;

import com.vivek.smart_debug_starter.Model.DebugReport;

public class Format {
    public static void print(DebugReport r){
        System.out.println("\n=================================");
        System.out.println("❌ SMART DEBUG REPORT");
        System.out.println("=================================");

        System.out.println("Root Cause: " + r.getRootException());
        System.out.println("Message: " + r.getMessage());

        if (r.getFileName() != null) {
            System.out.println("Location: " +
                    r.getFileName() + ":" + r.getLineNumber());
        } else {
            System.out.println("Location: Not found (no user code)");
        }

        if (r.getExceptionChain() != null) {
            System.out.println("Exception Chain: " +
                    String.join(" → ", r.getExceptionChain()));
        }

        System.out.println("=================================\n");
    }
}
