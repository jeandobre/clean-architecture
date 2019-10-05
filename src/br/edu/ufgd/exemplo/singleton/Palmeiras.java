package br.edu.ufgd.exemplo.singleton;

public class Palmeiras {

    public static final Palmeiras INSTANCE = new Palmeiras();

    private Palmeiras(){}

    public void leaveTheBuilding(){
        System.out.println("Exemplo de implementação 1, Palmeiras!!!!");
    }
}
