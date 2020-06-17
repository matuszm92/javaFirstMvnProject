package com.zaprogramowani.calculator;

import org.apache.commons.lang3.Validate;

public class CalculatorExpression {
    private String expression;

    public CalculatorExpression(String expression) {
        Validate.notBlank(expression);
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

}