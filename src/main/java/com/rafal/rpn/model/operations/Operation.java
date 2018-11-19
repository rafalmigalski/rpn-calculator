package com.rafal.rpn.model.operations;

public interface Operation<T> {
    T execute(T o1, T o2);
}
