package br.edu.ufgd.exemplo.genericos;

import java.util.*;
import java.util.function.UnaryOperator;

public class Exemplo30 {

    private Exemplo30() {
    }

    //Usa tipos brutos - inaceitável
    public static Set unionComWarning(Set s1, Set s2){
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }

    //Método genérico
    public static <E> Set<E> union(Set<E> s1, Set<E> s2){
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    /**
     * Exemplo de aplicação de singleton genérico
     *
     */
    private static UnaryOperator<Object> IDENTIFY_FN = t -> t;

    @SuppressWarnings("unchecked")
    public static <T> UnaryOperator<T> identityFunction(){
        return (UnaryOperator<T>) IDENTIFY_FN;
    }

    /**
     * Exemplo de comparabilidade mútua, ou seja, pode ser comparado
     * a ele mesmo
     */
    public static <E extends Comparable<E>> E max(Collection<E> c){
        if(c.isEmpty()) throw new IllegalArgumentException("Empty collection");

        E result = null;
        for(E e: c)
            if(result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);

        return result;
    }
}
