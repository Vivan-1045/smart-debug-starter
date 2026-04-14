package com.vivek.smart_debug_starter.Analyzer;

import com.vivek.smart_debug_starter.Filter.FilterNoise;
import com.vivek.smart_debug_starter.Model.DebugReport;
import com.vivek.smart_debug_starter.Suggestions.genrateSuggestion;
import jdk.jshell.SourceCodeAnalysis;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DebugAnalyser {
    public static DebugReport analyze(Throwable ex){
        DebugReport dbReport = new DebugReport();

        List<String> chain = ExceptionChainBuilder.buildChain(ex);

        if (!chain.isEmpty()) {
            dbReport.setRootException(chain.get(0));
        } else {
            dbReport.setRootException(ex.getClass().getSimpleName());
        }

        dbReport.setMessage(ex.getMessage());
        dbReport.setExceptionChain(chain);

        StackTraceElement userCode =
                FilterNoise.findUserCode(ex.getStackTrace());

        if (userCode != null){
            dbReport.setClassName(userCode.getClassName());
            dbReport.setFileName(userCode.getFileName());
            dbReport.setLineNumber(userCode.getLineNumber());
        }

        List<StackTraceElement> flowElement = FilterNoise.getExecutionFlow(ex.getStackTrace());
        List<String> flow = flowElement.stream()
                .map(el -> {
                    String fullClassName = el.getClassName();
                    String simpleClassName = fullClassName.substring(fullClassName.lastIndexOf('.') + 1);
                    return simpleClassName + "." + el.getMethodName();
                })
                .distinct()
                .collect(Collectors.toList());

        Collections.reverse(flow);
        dbReport.setFlow(flow);

        String suggestion = genrateSuggestion.getSuggestion(ex);
        dbReport.setSuggestions(suggestion);

        return dbReport;
    }
}
