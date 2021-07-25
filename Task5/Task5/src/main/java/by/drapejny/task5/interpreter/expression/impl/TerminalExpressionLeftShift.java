package by.drapejny.task5.interpreter.expression.impl;

import by.drapejny.task5.interpreter.Context;
import by.drapejny.task5.interpreter.expression.BaseExpression;

public class TerminalExpressionLeftShift implements BaseExpression {
    @Override
    public void interpret(Context context) {
        context.pushValue(context.popValue() << context.popValue());
    }
}
