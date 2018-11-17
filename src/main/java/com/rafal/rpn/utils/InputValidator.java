package com.rafal.rpn.utils;

public final class InputValidator {

    public static boolean isParameterValid(String[] args) {
        if (args.length == 0) {
            System.out.println("Not enough arguments");
            System.exit(-1);
        }
        if (args.length > 1) {
            System.out.println("Too much arguments");
            System.exit(-1);
        }
        return Boolean.TRUE;
    }

    //TODO: Check for valid expression itself to prevent exception with stack.
}
