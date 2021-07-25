package by.drapejny.task5.interpreter;

import by.drapejny.task5.interpreter.expression.BaseExpression;
import by.drapejny.task5.interpreter.expression.impl.*;

import java.util.ArrayList;

public class Interpreter {

    private ArrayList<BaseExpression> listExpression;

    public Interpreter(String expression){
        listExpression = new ArrayList<>();
        parse(expression);
    }

    public int calculate(){
        Context context = new Context();
        for(BaseExpression terminal : listExpression){
            terminal.interpret(context);
        }
        return context.popValue();
    }

    private void parse(String expression){
        for(String token : expression.split("\\s")){
            switch (token){
                case "|":
                    listExpression.add(new TerminalExpressionOr());
                    break;
                case "&":
                    listExpression.add(new TerminalExpressionAnd());
                    break;
                case "^":
                    listExpression.add(new TerminalExpressionXor());
                    break;
                case "~":
                    listExpression.add(new TerminalExpressionNot());
                    break;
                case "<<":
                    listExpression.add(new TerminalExpressionLeftShift());
                    break;
                case ">>":
                    listExpression.add(new TerminalExpressionRightShift());
                    break;
                case ">>>":
                    listExpression.add(new TerminalExpressionUnsignedRightShift());
                    break;
                default:
                    Integer number = Integer.parseInt(token);
                    listExpression.add(new NonterminalExpressionNumber(number));
            }
        }
    }
}
