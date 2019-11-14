package br.exemplo.singleton;


//A melhor abordagem - Abordagem aconselhável
public enum Exemplo3 {

    INSTANCE;

    public void leaveTheBuilding(){
        System.out.println("Exemplo 3 de Singleton");
    }

}
