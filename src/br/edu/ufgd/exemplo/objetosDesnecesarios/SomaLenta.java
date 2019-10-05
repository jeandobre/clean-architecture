package br.edu.ufgd.exemplo.objetosDesnecesarios;

public class SomaLenta {

    public void processar(){
        Long sum = 0L;
        for(long i = 0; i < Integer.MAX_VALUE; i++){
            sum += i;
        }
        System.out.println(sum);
    }
}
