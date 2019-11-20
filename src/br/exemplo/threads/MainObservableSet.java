package br.exemplo.threads;

import java.util.HashSet;

public class MainObservableSet {

    public static void main(String[] args){
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());

        //set.addObserver((s, e) -> System.out.println(e));

        //Exemplo de concurrentModificationException
        set.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(ObservableSet<Integer> set, Integer element) {
                System.out.println(element);
                if(element == 23)
                    set.removeObserver(this);
            }
        });

        for(int i = 0; i < 100; i++)
            set.add(i);
    }
}
