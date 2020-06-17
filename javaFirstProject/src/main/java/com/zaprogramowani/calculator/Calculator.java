package com.zaprogramowani.calculator;

public class Calculator {

    public int evaluate(CalculatorExpression expression) {
        int sum = 0;
        for (String summand : expression.getExpression().split("\\+"))
            sum += Integer.valueOf(summand);
        return sum;
    }

}