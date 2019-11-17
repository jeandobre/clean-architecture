package br.exemplo;

import java.util.*;
import static java.util.Comparator.comparingInt;

public class Exemplo42 {

    //Instância de classe anônima como um objeto de função - obsoleta!
    public static void main(String[] args){
        List<String> words = Arrays.asList("a", "b", "z", "c", "a");
        Exemplo42.ordenarLista(words);
        System.out.println(words);

        //Evitar usar streams para valores CHAR
        //outro exemplo, item 45
        "Hello world!".chars().forEach(System.out::print);

        //Corrigindo
        "Hello world!".chars().forEach(x -> System.out.print((char) x));
    }

    private static void ordenarLista(List<String> words) {

        Collections.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });
    }

    private static void ordenarListaNova(List<String> words){
        // Expressão lambda como função de objeto (substitue a classe anônima)
        Collections.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
    }

    // Método de construção de comparador
    private static void ordenarListaNova3(List<String> words){
        Collections.sort(words, comparingInt(String::length));
    }

    // Método mais curto com o Java 8
    private static void ordenarListaNova4(List<String> words){
        words.sort(comparingInt(String::length));
    }


}
