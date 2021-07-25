package by.drapejny.task5.interpreter;

import java.util.ArrayDeque;

public class Context {

    private ArrayDeque<Integer> contextValues = new ArrayDeque<>();

    public Context(){}

    public Integer popValue() {
        return contextValues.pop();
    }

    public void pushValue(Integer value) {
        contextValues.push(value);
    }
}
