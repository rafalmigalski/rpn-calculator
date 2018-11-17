package com.rafal.rpn.core;

import org.springframework.stereotype.Component;

import javax.naming.OperationNotSupportedException;
import java.util.Stack;

import static com.rafal.rpn.model.Operation.operate;
import static com.rafal.rpn.utils.ExpressionParser.parseExpression;
import static org.apache.commons.lang3.math.NumberUtils.isParsable;

@Component
class RPNCalculator {

    public Double calculate(String expression) throws OperationNotSupportedException {
        Stack<Double> rpn = new Stack<>();

        for (String value : parseExpression(expression)) {
            if (isParsable(value)) {
                handleDigit(Double.parseDouble(value), rpn);
            } else {
                handleOperand(value, rpn);
            }
        }
        return rpn.pop();
    }

    private void handleDigit(Double value, Stack<Double> rpn) {
        rpn.push(value);
    }

    private void handleOperand(String operation, Stack<Double> rpn) throws OperationNotSupportedException {
        rpn.push(operate(operation, rpn.pop(), rpn.pop()));
    }
}
