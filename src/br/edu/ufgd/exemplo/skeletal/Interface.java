package br.edu.ufgd.exemplo.skeletal;

import java.util.Objects;
import java.util.function.Predicate;

//Apenas um exemplo de interface com método default
public interface Interface<E> {

    default boolean removeIf(Predicate<? super E> filter){
        Objects.requireNonNull(filter);
        return false;
    }
}
