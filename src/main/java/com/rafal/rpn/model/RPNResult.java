package com.rafal.rpn.model;

public final class RPNResult {

    private final OperationResult status;
    private final Long result;

    public RPNResult(OperationResult status, Long result) {
        this.status = status;
        this.result = result;
    }

    public OperationResult getStatus() {
        return status;
    }

    public Long getResult() {
        return result;
    }
}
