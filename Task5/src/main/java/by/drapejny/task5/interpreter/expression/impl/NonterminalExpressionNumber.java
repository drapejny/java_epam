package by.drapejny.task5.interpreter.expression.impl;

import by.drapejny.task5.interpreter.Context;
import by.drapejny.task5.interpreter.expression.BaseExpression;

public class NonterminalExpressionNumber implements BaseExpression {

    private int number;

    public NonterminalExpressionNumber(int number) {
        this.number = number;
    }

    @Override
    public void interpret(Context contex) {
        contex.pushValue(number);
    }
}
