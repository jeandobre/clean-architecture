package br.edu.ufgd.exemplo.adapter;

import java.util.AbstractList;
import java.util.List;

/**
 * Exemplo de implementação de classe esquelética
 * junção de AbstractInterface
 * Template méthod
 *
 * Este exemplo também é um adapter
 *
 */
public class Exemplo1 {

    static List<Integer> intArrayAsList(int[] a){
        //Classe anônima
        return new AbstractList<Integer>() {
            @Override
            public Integer get(int index) {
                return a[index]; //Autoboxing
            }

            @Override
            public Integer set(int index, Integer element) {
               int oldVal = a[index];   //Autounboxing
               a[index] = element;      //Autoboxing
               return oldVal;
            }

            @Override
            public int size() {
                return a.length;
            }
        };
    }
}
