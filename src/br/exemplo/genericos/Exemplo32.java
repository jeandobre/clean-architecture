package br.exemplo.genericos;

import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Exemplo32 {

    //Misturar os genéricos com os varargs pode violar o type safety
    static void dangerous(List<String>...stringLists){
        List<Integer> intList = asList(42);
        Object[] objects = stringLists;
        objects[0] = intList;
        String s = stringLists[0].get(0);
    }

    //INSEGURO - Expõe a referência ao seu array de parâmetro genérico
    static <T> T[] toArray(T...args){
        return args;
    }

    static <T> T[] pickTwo(T a, T b, T c){
        switch (ThreadLocalRandom.current().nextInt(3)){
            case 0: return toArray(a, b);
            case 1: return toArray(a, c);
            case 2: return toArray(b, c);
        }
        throw new AssertionError(); //Não pode chegar até aqui
    }

    //Método seguro com um parâmetro varargs genérico
    @SafeVarargs
    static <T> List<T> flatten(List<? extends T>...lists){
        List<T> result = new ArrayList<>();
        for(List<? extends T> list: lists)
            result.addAll(list);
        return result;
    }

    //Lista como uma alternativa de tipo para um parâmetro genérico varargs
    static <T> List<T> flatten2(List<List<? extends T>> lists){
        List<T> result = new ArrayList<>();
        for(List<? extends T> list: lists)
            result.addAll(list);
        return result;
    }
}
