package br.edu.ufgd.exemplo.singleton;

import java.util.Comparator;

/**
 * Esta classe é um exemplo de objetos de função
 * que são normalmente implementados como singleton
 *
 * Extendi de Comparator<T> que é uma interface de estratégia
 */
class StringLengthComparator implements Comparator<String> {

    public static final StringLengthComparator INSTANCE = new StringLengthComparator();

    public int compare(String s1, String s2){
        return s1.length() - s2.length();
    }

}
