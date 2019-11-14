package br.exemplo.singleton;

public class Elvis {

    private static final Elvis INSTANCE = new Elvis();

    private Elvis(){

    }

    public static Elvis getInstance(){
        return INSTANCE;
    }

    public void leaveTheBulding(){
        System.out.println("Singleton Exemplo 2");
    }

}
