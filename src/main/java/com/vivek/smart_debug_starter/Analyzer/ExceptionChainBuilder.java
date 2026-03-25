package com.vivek.smart_debug_starter.Analyzer;

import java.util.ArrayList;
import java.util.List;

public class ExceptionChainBuilder {
    public static List<String> buildChain(Throwable e){
        List<String> chain = new ArrayList<>();

        Throwable curr = e;
        while (curr != null){
            chain.add(curr.getClass().getSimpleName());
            curr = curr.getCause();
        }

        return chain;
    }
}
