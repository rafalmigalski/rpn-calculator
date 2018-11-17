package com.rafal.rpn.core;

import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertEquals;

public class RPNCalculatorTest {

    private RPNCalculator rpnCalculator = new RPNCalculator();

    @Test
    public void shouldCalculateRPNExpression() throws OperationNotSupportedException {
        String givenExpression = "3 11 + 5 -";

        Double result = rpnCalculator.calculate(givenExpression);

        assertEquals(Double.valueOf(9), result);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldWarnNotSupported() throws OperationNotSupportedException {
        String givenExpression = "3 11 + 5 *";

        Double result = rpnCalculator.calculate(givenExpression);

        assertEquals(Double.valueOf(9), result);
    }
}
