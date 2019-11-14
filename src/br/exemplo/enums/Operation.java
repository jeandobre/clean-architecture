package br.exemplo.enums;

import static java.util.stream.Collectors.toMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

//tipo de enum com implementações de método específico para constante

/**
 * Use os enums sempre que precisar de um conjunto de constantes cujos
 * membros são conhecidos em tempo de compilação
 *
 * Não é necessário que o conjunto de constantes em um tipo enum
 * seja sempre fixo.
 *
 */
public enum Operation {
    PLUS("+")  { public double apply(double x, double y){return x + y;}},
    MINUS("-") { public double apply(double x, double y){return x - y;}},
    TIMES("*") { public double apply(double x, double y){return x * y;}},
    DIVIDE("/"){ public double apply(double x, double y){return x / y;}};

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;

        // Não é possível acessar as constantes ENUM do construtor
        //Isso aqui nao compila
        //if(this.PLUS.symbol.equals("*")){
        //    System.out.println("teste");
        //}
    }

    public abstract double apply(double x, double y);

    @Override
    public String toString() {
        return symbol;
    }

    // Implemntação de um método fromString em um tipo enum
    private static final Map<String, Operation> stringToEnum =
            Stream.of(values()).collect(toMap(Object::toString, e -> e));

    // Retorna a Operation para a string, se tiver
    public static Optional<Operation> fromString(String symbol){
        return Optional.ofNullable(stringToEnum.get(symbol));
    }

    // Switch em um enum para simular um método que falta
    public static Operation inverse(Operation op){
        switch (op){
            case PLUS: return Operation.MINUS;
            case MINUS: return Operation.PLUS;
            case TIMES: return Operation.DIVIDE;
            case DIVIDE: return Operation.TIMES;

            default: throw new AssertionError("Unknown op:" + op);
        }
    }
}
