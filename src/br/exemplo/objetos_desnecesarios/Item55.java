package br.exemplo.objetos_desnecesarios;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Item55 {

    //retorna o valor máximo na coleção - exceção lançada se vazia
    public static <E extends Comparable<E>> E max(Collection<E> c){
        if(c.isEmpty())
            throw new IllegalArgumentException("Empty collection");

        E result = null;
        for(E e: c)
            if(result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);

        return result;
    }

    //retorna o valor máximo na coleção como uma Opctional <E>
    public static <E extends Comparable<E>> Optional<E> max2(Collection<E> c){
        if(c.isEmpty())
            return Optional.empty();

        E result = null;
        for(E e: c)
            if(result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);

        return Optional.of(result);
    }

    // Retorna o valor max, na coleção como Optional <E> - usa uma stream
    public static <E extends Comparable<E>> Optional<E> max3(Collection<E> c){
        return c.stream().max(Comparator.naturalOrder());
    }

    public void processador(ProcessHandle ph){
        Optional<ProcessHandle> parentProcess = ph.parent();
        System.out.println("Parent PID: " + (parentProcess.isPresent() ?
                String.valueOf(parentProcess.get().pid()) : "N/A"));
    }

    //Correto
    public void processador2(ProcessHandle ph){
        System.out.println("Parent PID: " +
                ph
                        .parent()
                        .map(h -> String.valueOf(h.pid()))
                        .orElse("N/A"));
    }

    /**
     * Retorna true se a collection está vazia.
     * @author jeandobre
     *
     * @implSpec
     * Esta implementação retorna {@code this.size() == 0}
     *
     * Exemplo de indexação de palavras {@index estranhas}
     * Cuidado com o ponto final., {@literal Me.} ou Dr.
     *
     * @return true se a collection está vazia
     */
    public void converterStreamOptionalTParaStreamT(){
        //Stream<Optional<String>> streamOfOptionals = new ArrayList<String>().stream();
        //streamOfOptionals.fil

        //List<String> lista = new ArrayList<>();
        //lista.removeIf(Predicate.isEqual("Jean"));
    }

    /**
     * Exemplo de documentação de enum
     *
     * @param <K> o tipo de chave matinda por este Map
     * @param <V> o tipo de valores mapeados
     */
    public interface Map<K, V> {
    }

    /**
     * Uma seção de instrumentos de uma orquestra sinfônica
     */
    public enum OrchestraSection{
        /** Instrumentos de sopro, como flauta, clarinetee oboé */
        INSTRUMENTOS_DE_SOPRO,
        /** Instrumentos de bronze, como trompa e trompete */
        BRONZE,
        /** Instrumentos de percursão, como0 timpani e pratos. */
        PERCURSÃO;
    }

    /**
     * Indica que um método anotado é um método de teste que
     * dev lançar uma exceção designada para passar.
     */
    public @interface ExceptionTest{
        /**
         * A exeção bla bla bla...
         */
        Class<? extends Throwable> value();
    }
}