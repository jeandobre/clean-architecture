package br.exemplo.lambdas_streams;

import java.util.function.DoubleBinaryOperator;

// Enum com campo de objeto de função & comportamento específico para constantes
public enum Operation {
    PLUS("+", (x, y) -> x + y),
    MINUS("-",  (x, y) -> x - y),
    TIMES("*",  (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private final String symbol;
    private final DoubleBinaryOperator op;

    Operation(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    public double apply(double x, double y){
        return op.applyAsDouble(x, y);
    }

    @Override
    public String toString() {
        return symbol;
    }
}
