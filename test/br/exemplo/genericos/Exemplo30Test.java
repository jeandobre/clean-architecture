package br.exemplo.genericos;

import org.junit.Test;

import java.util.function.UnaryOperator;
import static br.exemplo.genericos.Exemplo30.identityFunction;

public class Exemplo30Test {

    @Test
    public void testarSingletonGenerico(){
        String[] strings = {"jute", "hemp", "nylon"};
        UnaryOperator<String> sameString = identityFunction();
        for(String s: strings)
            System.out.println(sameString.apply(s));

        Number[] numbers = { 1, 2.0, 3L };
        UnaryOperator<Number> sameNumber = identityFunction();
        for(Number n: numbers)
            System.out.println(sameNumber.apply(n));

    }
}
