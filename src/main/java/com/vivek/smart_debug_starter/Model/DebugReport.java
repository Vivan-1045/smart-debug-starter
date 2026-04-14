package com.vivek.smart_debug_starter.Model;

import lombok.Data;

import java.util.List;

@Data
public class DebugReport {
    private String rootException;
    private String message;
    private String className;
    private String fileName;
    private int lineNumber;
    private List<String> exceptionChain;
    private List<String> flow;
    private String suggestions;

}
