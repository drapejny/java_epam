package by.drapejny.task5.utils;

import java.util.ArrayDeque;
import java.util.Arrays;

public class PostfixNotationTransformer {

    private static final String TOKEN_SPLIT_REGEX = "(?<=([|&^~()]|>>|<<|>>>))|(?=([|&^~()]|>>|<<|>>>))";

    public String transform(String expression) {
        String[] tokens = expression.split(TOKEN_SPLIT_REGEX);
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push("#");
        String postfixExpression = "";
        for (String token : tokens) {
            int priority = calculatePriority(token);
            if (priority == -1) {
                postfixExpression += " " + token;
            } else if (priority == 1) {
                String current = stack.pop();
                while (!current.equals("(")) {
                    postfixExpression += " " + current;
                    current = stack.pop();
                }
            } else if (priority == 0 || priority > calculatePriority(stack.peek())) {
                stack.push(token);
            } else {
                while (priority <= calculatePriority(stack.peek())) {
                    postfixExpression += " " + stack.pop();
                }
                stack.push(token);
            }
        }
        if (!stack.peek().equals("#")) {
            while (!stack.peek().equals("#")) {
                postfixExpression += " " + stack.pop();
            }
        }
        return postfixExpression.trim();
    }

    private int calculatePriority(String operator) {
        switch (operator) {
            case "(":
                return 0;
            case ")":
                return 1;
            case "|":
                return 2;
            case "^":
                return 3;
            case "&":
                return 4;
            case "<<":
            case ">>":
            case ">>>":
                return 5;
            case "~":
                return 6;
            case "#":
                return -2;
            default:
                return -1;
        }
    }
}
