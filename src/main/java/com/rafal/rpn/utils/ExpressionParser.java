package com.rafal.rpn.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.rafal.rpn.model.Operation.fromString;
import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.math.NumberUtils.isParsable;

public final class ExpressionParser {

    public static List<String> parseExpression(String expression) {
        return Arrays.stream(expression.split("\\s+")).collect(Collectors.toList());
    }

    public static boolean hasValidExpression(String expression) {
        return parseExpression(expression).stream().filter(exp -> !isParsable(exp)).allMatch(ExpressionParser::isSupportedOperand);
    }

    private static boolean isSupportedOperand(String operand) {
        return nonNull(fromString(operand)) ? Boolean.TRUE : Boolean.FALSE;
    }
}
