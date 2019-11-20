package br.exemplo.threads;

import br.exemplo.decorator.ForwardingSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

//Quebrado - invoca um método desconhecido para a sincronização do bloco!
public class ObservableSet<E> extends ForwardingSet<E> {
    public ObservableSet(Set<E> set){
        super(set);
    }

    //private final List<SetObserver<E>> observers = new ArrayList<>();
    private final List<SetObserver<E>> observers = new CopyOnWriteArrayList<>();

    public void addObserver(SetObserver<E> observer){
        //synchronized (observers){
            observers.add(observer);
       // }
    }

    public boolean removeObserver(SetObserver<E> observer){
       // synchronized (observers){
            return observers.remove(observer);
      //  }
    }
    //Errado, errro de syncronização
    /*
    private void notiflyElementAdded(E element){

        synchronized (observers){
            for(SetObserver<E> observer : observers)
                observer.added(this, element);
        }
    } */

    //Método estranho deslocado para fora do bloco sincronizado - abre a chamada
    private void notiflyElementAdded(E element){
      /*  List<SetObserver<E>> snapshot = null;
        synchronized (observers){
            snapshot = new ArrayList<>(observers);
        }
        for(SetObserver<E> observer : snapshot)
            observer.added(this, element);*/
      for(SetObserver<E> observer : observers)
            observer.added(this, element);
    }

    @Override
    public boolean add(E element) {
        boolean added = super.add(element);
        if(added)
            notiflyElementAdded(element);
        return added;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for(E element : c)
            result |= add(element); // Chama a notifyElementAdded

        return result;
    }
}
