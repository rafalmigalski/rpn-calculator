package com.rafal.rpn.core;

import org.junit.Test;

import static java.lang.Double.valueOf;
import static org.junit.Assert.assertEquals;

public class RPNCalculatorTest {

    private RPNCalculator rpnCalculator = new RPNCalculator();

    @Test
    public void shouldCalculateRPNExpression() {
        String givenExpression = "9 5 3 + 2 4 ^ - + ";

        Double result = rpnCalculator.calculate(givenExpression);

        assertEquals(valueOf(1), result);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldWarnOperationNotSupported() {
        String givenExpression = "3 11 + 5 &&";

        rpnCalculator.calculate(givenExpression);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldWarnInvalidExpression() {
        String givenExpression = "3 11 + 5 * &&";

        rpnCalculator.calculate(givenExpression);
    }
}
