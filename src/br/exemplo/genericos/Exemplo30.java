package br.exemplo.genericos;

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
    //Não use os tipos wildcards limitados com os tipos de retorno
    // o retorno ainda é Set<E>, não deve ser Set<? extends E>
    public static <E> Set<E> union(Set<? extends E> s1,
                                   Set<? extends E> s2){
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
    public static <T extends Comparable<? super T>> T max(Collection<? extends T> list){
        if(list.isEmpty()) throw new IllegalArgumentException("Empty collection");

        T result = null;
        for(T e: list)
            if(result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);

        return result;
    }

    /**
     * Exemplo swap item 31
     *
     */
    public static void swap(List<?> list, int i, int j){
        swapHelder(list, i, j);
    }

    //Método auxiliar privado para a captura do wildcard
    private static <E> void swapHelder(List<E> list, int i, int j){
        list.set(i, list.set(j, list.get(i)));
    }
}
