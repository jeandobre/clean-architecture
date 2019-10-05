package br.edu.ufgd.exemplo.singleton;


//A melhor abordagem
public enum Exemplo3 {

    INSTANCE;

    public void leaveTheBuilding(){
        System.out.println("Exemplo 3 de Singleton");
    }

}
