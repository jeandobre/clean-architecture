package br.exemplo.singleton;

public class Palmeiras {

    private static final Palmeiras INSTANCE = new Palmeiras();

    private Palmeiras(){}

    public static Palmeiras getInstance(){
        return INSTANCE;
    }

    public void leaveTheBuilding(){
        System.out.println("Exemplo de implementação 1, Palmeiras!!!!");
    }
}
