package com.rafal.rpn.model.operations;

public class ExpOperation implements Operation<Double> {
    @Override
    public Double execute(Double o1, Double o2) {
        return Math.pow(o1, o2);
    }
}
