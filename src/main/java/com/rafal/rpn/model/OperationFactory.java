package com.rafal.rpn.model;

public final class OperationFactory {

    public static Operation valueOf(String operation) {
        switch (operation) {
            case "+":       return new AddOperation();
            case "-":       return new SubOperation();
            case "*":       return new MulOperation();
            case "/":       return new DivOperation();
            case "^":       return new ExpOperation();
            default:        throw  new UnsupportedOperationException("Operation not supported yet.");
        }
    }
}
