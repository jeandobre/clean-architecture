package br.exemplo.enums;

public enum OperationRuim {
    PLUS, MINUS, TIMES, DIVIDE;

    // Faça operação aritimética representada por esta constante
    public double apply(double x, double y){
        switch (this){
            case PLUS: return x + y;
            case MINUS: return x - y;
            case TIMES: return x * y;
            case DIVIDE: return x / y;
        }
        throw new AssertionError("Unknown op: " + this);
    }
}
