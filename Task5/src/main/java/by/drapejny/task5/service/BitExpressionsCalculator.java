package by.drapejny.task5.service;

import by.drapejny.task5.interpreter.Interpreter;
import by.drapejny.task5.utils.PostfixNotationTransformer;

import java.util.function.UnaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BitExpressionsCalculator {

    private static final String BIT_EXPRESSION_REGEX = "\\(*(?=\\d|~)[0-9|&~^<>()]+";

    public static String calculate(String text) {
        var transformer = new PostfixNotationTransformer();
        StringBuffer resultText = new StringBuffer();
        Pattern pattern = Pattern.compile(BIT_EXPRESSION_REGEX);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String expression = matcher.group();
            String postfixExpression = transformer.transform(expression);
            Interpreter interpreter = new Interpreter(postfixExpression);
            String resultNumber = Integer.toString(interpreter.calculate());
            matcher.appendReplacement(resultText, resultNumber);
        }
        matcher.appendTail(resultText);
        return resultText.toString();
    }
}
