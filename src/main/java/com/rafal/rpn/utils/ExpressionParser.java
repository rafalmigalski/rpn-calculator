package com.rafal.rpn.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class ExpressionParser {

    public static List<String> parseExpression(String expression) {
        return Arrays.stream(expression.split("\\s+")).collect(Collectors.toList());
    }
}
