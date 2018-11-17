package com.rafal.rpn.model;

import javax.naming.OperationNotSupportedException;

import static java.util.Arrays.stream;
import static org.apache.commons.lang3.StringUtils.equalsIgnoreCase;

public enum Operation {
    ADDITION("+"),
    SUBTRACTION("-"),
    UNSUPPORTED("...");

    private final String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public static Double operate(String operation, Double x , Double y) throws OperationNotSupportedException {
        switch (fromString(operation)) {
            case ADDITION:       return y + x;
            case SUBTRACTION:    return y - x;
            default:             throw new OperationNotSupportedException("Operation not supported yet.");
        }
    }

    public static Operation fromString(String operation) {
        return stream(Operation.values()).filter(op -> equalsIgnoreCase(op.operation, operation)).findFirst().orElse(UNSUPPORTED);
    }
}
