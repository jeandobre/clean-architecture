package br.exemplo.lambdas_streams;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * Classe exemplo do item 47 do livro Java Efetivo
 *
 */
public class SubLists {

    //Retorna uma stream de todas as sublistas de sua lista de entrada
    public static <E> Stream<List<E>> of(List<E> list){
        return Stream.concat(Stream.of(Collections.emptyList()),
                prefixes(list).flatMap(SubLists::suffixes));
    }

    private static <E> Stream<List<E>> prefixes(List<E> list){
        return IntStream.rangeClosed(1, list.size())
                .mapToObj(end -> list.subList(0, end));
    }

    private static <E> Stream<List<E>> suffixes(List<E> list){
        return IntStream.range(0, list.size())
                .mapToObj(start -> list.subList(start, list.size()));
    }

    //Retorna uma stream de todas as sublistas de sua lista de entrada versão 2
    public static <E> Stream<List<E>> of2(List<E> list){
        return IntStream.range(0, list.size())
                .mapToObj(start -> IntStream.rangeClosed(start + 1, list.size())
                .mapToObj(end -> list.subList(start, end)))
                .flatMap(x -> x);
    }

}
