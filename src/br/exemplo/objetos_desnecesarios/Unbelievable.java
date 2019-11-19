package br.exemplo.objetos_desnecesarios;

import java.util.Comparator;

public class Unbelievable {
    static Integer i;

    public static void main(String[] args){
        if( i == 42)
            System.out.println("Unbelievable");
    }

    //Vai falhar quando AutoUnbox ou Autobox (Integer)
    Comparator<Integer> naturalOrder = (i, j) -> (i < j) ? -1 : (i == j ? 0 : 1);

    //Forma correta
    Comparator<Integer> naturalOrder2 = (iBoxed, jBoxed) -> {
      int i = iBoxed, j = jBoxed; // Autounboxing
      return i < j ? -1 : (i == j ? 0 : 1);
    };

}
