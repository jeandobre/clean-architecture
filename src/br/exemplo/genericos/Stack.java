package br.exemplo.genericos;

import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

/**
 * Exemplo de generificação
 */
public class Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    // Os elementos do array terão apenas as instâncias E do push(E.
    //Isso é o bastante para assegurar o type safety, porém o tipo de
    // tempo da execução não será E[] e sim Object E[]!
    @SuppressWarnings("unchecked")
    public Stack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e){
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop(){
        if(size == 0) throw new EmptyStackException();
        // O push exige elements que sejam do tipo E, então o cast está correto
        @SuppressWarnings("unchecked")
        E result = (E) elements[--size];
        elements[size] = null; //Elimine as referêcias obsoletas
        return result;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void ensureCapacity(){
        if(elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    // TIpo de wildcard para um parâmetro que funciona como um produtor E
    public void pushAll(Iterable<? extends E> src){
        //Iterable de algum subtipo de E
        for(E e : src)
            push(e);
    }

    //Método popAll sem tipo de wildcard - deficiente
    public void popAll(Collection<? super E> dst){
        //Coleção de algum supertipo de E
        while(!isEmpty())
            dst.add(pop());
    }

    //PECS é a abreviação para PRODUTOR-EXTENDS, CONSUMIDOR-SUPER
    //se for um produtor-T use <? extends T>
    //se for um consumidor-T use <? super T>
}
