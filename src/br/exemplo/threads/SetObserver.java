package br.exemplo.threads;

@FunctionalInterface
public interface SetObserver<E> {
    //Invocada quando um elemento é adicionado ao set observável
    void added(ObservableSet<E> set, E element);
}
