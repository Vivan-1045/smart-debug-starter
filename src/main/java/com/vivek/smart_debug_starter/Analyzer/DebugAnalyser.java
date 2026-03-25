package com.vivek.smart_debug_starter.Analyzer;

import com.vivek.smart_debug_starter.Filter.FilterNoise;
import com.vivek.smart_debug_starter.Model.DebugReport;

public class DebugAnalyser {
    public static DebugReport analyze(Throwable ex){
        DebugReport dbReport = new DebugReport();

        Throwable rootCause = RootCauseExtracter.getRootCause(ex);

        dbReport.setRootException(rootCause.getClass().getSimpleName());
        dbReport.setMessage(rootCause.getMessage());

        dbReport.setExceptionChain(ExceptionChainBuilder.buildChain(ex));

        StackTraceElement userCode = FilterNoise.findUserCode(rootCause.getStackTrace());
        if (userCode != null){
            dbReport.setClassName(userCode.getClassName());
            dbReport.setFileName(userCode.getFileName());
            dbReport.setLineNumber(userCode.getLineNumber());
        }

        return dbReport;
    }

}
