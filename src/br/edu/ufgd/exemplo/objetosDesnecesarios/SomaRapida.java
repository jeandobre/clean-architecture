package br.edu.ufgd.exemplo.objetosDesnecesarios;

public class SomaRapida {

    public void processar(){
        long sum = 0L;
        for(long i = 0; i < Integer.MAX_VALUE; i++){
            sum += i;
        }
        System.out.println(sum);
    }
}
