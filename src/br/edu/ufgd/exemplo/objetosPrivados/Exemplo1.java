package br.edu.ufgd.exemplo.objetosPrivados;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exemplo1 {

    private static final Thing[] PRIVATE_VALUES = {};

    public class Thing {

    }

    //Forma correta de expor listas
    public static final List<Thing> VALUES =
            Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));

    //Alternativa:
    public static final Thing[] values(){
        return PRIVATE_VALUES.clone();
    }
}
