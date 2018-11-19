package com.rafal.rpn.model;

public interface Operation<T> {
    T execute(T o1, T o2);
}
