package com.zaprogramowani.calculator;

import org.junit.Test;

public class CalculatorExpressionTest {
 
    @Test(expected = NullPointerException.class)
    public void shouldThrowNPEWhenExpressionIsNull() {
        // when
        new CalculatorExpression(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenExpressionIsBlank() {
        // when
        new CalculatorExpression("");
    }

}