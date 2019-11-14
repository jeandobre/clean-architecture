package br.exemplo.genericos;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ChooserErrado {
    private final Object[] choiceArray;

    public ChooserErrado(Collection choices) {
        this.choiceArray = choices.toArray();
    }

    public Object choose(){
        Random rnd = ThreadLocalRandom.current();
        return choiceArray[rnd.nextInt(choiceArray.length)];
    }
}
