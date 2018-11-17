package com.rafal.rpn.persistance;

public interface RPNRepository<S, F> {
    F fetch();
    void store(S result);
}
