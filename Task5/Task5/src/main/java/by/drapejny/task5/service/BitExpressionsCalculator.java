package by.drapejny.task5.service;

import by.drapejny.task5.interpreter.Interpreter;
import by.drapejny.task5.utils.PostfixNotationTransformer;

import java.util.function.UnaryOperator;

public class BitExpressionsCalculator {

    private static final String BIT_EXPRESSION_REGEX = "\\(*(?=\\d|~)[0-9|&~^<>()]+";

    public static String calculate(String text) {
        UnaryOperator<String> unaryOperator = (expression) -> {
            var transformer = new PostfixNotationTransformer();
            String postfixExpression = transformer.transform(expression);
            Interpreter interpreter = new Interpreter(postfixExpression);
            return Integer.toString(interpreter.calculate());
        };
        text.replaceAll(BIT_EXPRESSION_REGEX,unaryOperator.apply("$0"));
        return text;
    }
}
