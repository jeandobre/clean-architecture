package br.exemplo;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Exemplo46 {

    //Uso da APi de streams, mas não do paradigma -- Não faça isso
    private void usoApiStreams(String file){
        Map<String, Long> freq = new HashMap<>();
        try(Stream<String> words = new Scanner(file).tokens()){
            words.forEach(word -> {
                freq.merge(word.toLowerCase(), 1L, Long::sum);
            });
        }
    }

    //Uso apropriado das streams para inicializar uma tabela de frequência
    private void usoStremsCorreto(String file){
        Map<String, Long> freq;
        try(Stream<String> words = new Scanner(file).tokens()){
            freq = words
            .collect(groupingBy(String::toLowerCase, counting()));
        }
    }

    // Pipeline quea panha da tabela de frequência uma lista das 10 palavras mais usadas
    private void dezMais(Map<String, Long> freq){
        List<String> topTen = freq.keySet().stream()
                .sorted(comparing(freq::get).reversed())
                .limit(10)
                .collect(toList());

        //Integer.MAX_VALUE == 2^31 - 1;
    }

    // Adaptador da Stream<E> para Iterable<E>
    public static <E> Iterable<E> iterableOf(Stream<E> stream){
        return stream::iterator;
    }

    // Adaptador da Iterable<E> para a Stream<E>
    public static <E> Stream<E> streamOf(Iterable<E> iterable){
        return StreamSupport.stream(iterable.spliterator(), false);
    }
}
