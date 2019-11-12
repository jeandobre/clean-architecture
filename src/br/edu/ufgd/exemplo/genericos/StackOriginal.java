package br.edu.ufgd.exemplo.genericos;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Exemplo de generificação (Classe original)
 */
public class StackOriginal {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public StackOriginal() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e){
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop(){
        if(size == 0) throw new EmptyStackException();
        Object result = elements[--size];
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
}
