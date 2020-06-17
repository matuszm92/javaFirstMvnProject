package com.zaprogramowani.calculator;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
 
    @Test
    public void shouldEvaluateExpression() {
        // given
        CalculatorExpression expression = new CalculatorExpression("1+2+3+4");
        Calculator calculator = new Calculator();
        
        // when
        int result = calculator.evaluate(expression);
        
        
        // then
        int expected = 10;
        Assert.assertEquals(expected, result);
    }

}