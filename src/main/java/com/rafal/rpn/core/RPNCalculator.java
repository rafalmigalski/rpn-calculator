package com.rafal.rpn.core;

import org.springframework.stereotype.Component;

import java.util.Stack;

import static com.rafal.rpn.model.OperationFactory.valueOf;
import static com.rafal.rpn.utils.ExpressionParser.parseExpression;
import static java.lang.Double.parseDouble;
import static java.lang.String.format;
import static org.apache.commons.lang3.math.NumberUtils.isParsable;

@Component
class RPNCalculator {

    public Double calculate(String expression) {
        Stack<Double> rpn = new Stack<>();

        for (String value : parseExpression(expression)) {
            if (isParsable(value)) {
                handleDigit(parseDouble(value), rpn);
            } else {
                if (rpn.size() == 1) {
                    throw new IllegalArgumentException(format("Invalid rpn expression: %s", expression));
                }
                handleOperand(value, rpn);
            }
        }
        return rpn.pop();
    }

    private void handleDigit(Double value, Stack<Double> rpn) {
        rpn.push(value);
    }

    private void handleOperand(String operation, Stack<Double> rpn) {
        Double op1 = rpn.pop();
        Double op2 = rpn.pop();
        rpn.push((Double) valueOf(operation).execute(op2, op1));
    }
}
