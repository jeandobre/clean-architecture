package br.exemplo.genericos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

//Não usar array e sim lista
//Substituir arrays por lista
public class Chooser<T> {
    private final List<T> choiceList;

    public Chooser(Collection<? extends T> choices) {
        this.choiceList = new ArrayList<>(choices);
    }

    public Object choose(){
        Random rnd = ThreadLocalRandom.current();
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }
}
