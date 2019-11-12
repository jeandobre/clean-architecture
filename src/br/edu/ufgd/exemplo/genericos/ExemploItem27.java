package br.edu.ufgd.exemplo.genericos;

import java.util.Arrays;

public class ExemploItem27 {

    private int size;
    private String[] elements;

    public ExemploItem27(int size) {
        this.size = size;
    }

    public <T> T[] toArray(T[] a) {
        if (a.length < size){
            //Este cast está certo porque é o array que estamos criando
            // Este é o mesmo tipo que o tipo passado, que é T[].
            @SuppressWarnings("unchecked")
            T[]result = (T[]) Arrays.copyOf(elements, size, a.getClass());
            return result;
        }
        System.arraycopy(elements, 0, a, 0, size);
        if(a.length > size) a[size] = null;
        return a;
    }

    public void testeTiposGenericos(){
      /*  List<String>[] listaDeStrings = Arrays.asList([1]); // new ArrayList<String>()[1];
        List<Integer> listaDeInteiros = List.of(42);
        Object[] objects = listaDeStrings;
        objects[0] = listaDeInteiros;
        String s = listaDeStrings[0].get(0);*/
    }
}
