package by.drapejny.task5;

import by.drapejny.task5.interpreter.Interpreter;
import by.drapejny.task5.service.BitExpressionsCalculator;
import by.drapejny.task5.utils.PostfixNotationTransformer;

public class Main {
    public static void main(String[] args) {
        PostfixNotationTransformer transformer = new PostfixNotationTransformer();
        String infix = "4";//(7^5|1&2<<(~2|5>>2&71))|1200
        String postfix = transformer.transform(infix);
        int x = (7 ^ 5 | 1 & 2 << (~2 | 5 >> 2 & 71)) | 1200;
        Interpreter interpreter = new Interpreter(postfix);
        int y = interpreter.calculate();
        System.out.println(x);
        System.out.println(y);
    }
}
