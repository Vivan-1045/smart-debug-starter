package com.vivek.smart_debug_starter.Suggestions;

public class genrateSuggestion {
    public static String getSuggestion(Throwable ex){
        String name = ex.getClass().getSimpleName();

        if (name.contains("NullPointerException")) {
            return "Check for null values before accessing object methods or properties.";
        }

        if (name.contains("ArithmeticException")) {
            return "Avoid division by zero. Validate inputs before performing arithmetic operations.";
        }

        if (name.contains("IndexOutOfBoundsException") ||
                name.contains("StringIndexOutOfBoundsException")) {
            return "Check index bounds before accessing array or string elements.";
        }

        if (name.contains("IllegalArgumentException")) {
            return "Validate method arguments before passing them.";
        }

        if (name.contains("RuntimeException")) {
            return "Check wrapped exceptions for deeper root cause.";
        }

        return "We provide our RAG AI for get suggestions. ";
    }
}
