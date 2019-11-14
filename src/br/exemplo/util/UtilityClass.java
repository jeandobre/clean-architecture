package br.exemplo.util;

//Classe utilitária não instanciável
public class UtilityClass {

    //Suprima o construtor padrão para a não instanciação
    private UtilityClass() {
        throw new AssertionError();
    }
}
