package gaga.elmahdi.calculator.evaluator;

import org.mariuszgromada.math.mxparser.Expression;

public class Evaluator {

    public static String evaluate(String expression) {
        Expression expr = new Expression(expression);
        double result = expr.calculate();
        return Double.toString(result);
    }
}
