package com.vivek.smart_debug_starter.Analyzer;

import com.vivek.smart_debug_starter.Filter.FilterNoise;
import com.vivek.smart_debug_starter.Model.DebugReport;
import com.vivek.smart_debug_starter.Suggestions.genrateSuggestion;


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

        String basePackage = extractBasePackage(flowElement);

        List<String> flow = flowElement.stream()
                .map(el -> {
                    String simpleClassName = el.getClassName();
                    if (!basePackage.isEmpty() && simpleClassName.startsWith(basePackage)){
                        simpleClassName = simpleClassName.substring(basePackage.length()+1);
                    }

                    return simpleClassName + "." + el.getMethodName() +
                            "(" + el.getFileName() + ":" + el.getLineNumber() + ")";
                })
                .distinct()
                .collect(Collectors.toList());

        Collections.reverse(flow);
        dbReport.setFlow(flow);

        String suggestion = genrateSuggestion.getSuggestion(ex);
        dbReport.setSuggestions(suggestion);

        return dbReport;
    }

    public static String extractBasePackage(List<StackTraceElement> flowEle){
        if (flowEle == null || flowEle.isEmpty()) return "";

        String[] baseParts = flowEle.get(0).getClassName().split("\\.");

        for (int i = 1; i < flowEle.size(); i++) {
            String[] parts = flowEle.get(i).getClassName().split("\\.");

            int j = 0;
            while (j < baseParts.length && j < parts.length && baseParts[j].equals(parts[j])) {
                j++;
            }

            String[] newBase = new String[j];
            System.arraycopy(baseParts, 0, newBase, 0, j);
            baseParts = newBase;
        }

        return String.join(".", baseParts);
    }
}
