package com.rafal.rpn.model;

public class SubOperation implements Operation<Double> {
    @Override
    public Double execute(Double o1, Double o2) {
        return o1 - o2;
    }
}
