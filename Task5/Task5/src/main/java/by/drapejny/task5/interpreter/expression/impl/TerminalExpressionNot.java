package by.drapejny.task5.interpreter.expression.impl;

import by.drapejny.task5.interpreter.Context;
import by.drapejny.task5.interpreter.expression.BaseExpression;

public class TerminalExpressionNot implements BaseExpression {
    @Override
    public void interpret(Context contex) {
        contex.pushValue(~contex.popValue());

    }
}
