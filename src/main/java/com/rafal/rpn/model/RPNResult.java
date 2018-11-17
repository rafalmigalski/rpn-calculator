package com.rafal.rpn.model;

public final class RPNResult {

    private final OperationResult status;
    private final Double result;

    public RPNResult(OperationResult status, Double result) {
        this.status = status;
        this.result = result;
    }

    public OperationResult getStatus() {
        return status;
    }

    public Double getResult() {
        return result;
    }
}
