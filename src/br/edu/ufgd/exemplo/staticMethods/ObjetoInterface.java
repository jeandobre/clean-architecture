package br.edu.ufgd.exemplo.staticMethods;

/**
 * Classe para exemplificar os motivos de usar métodos estáticos
 * ao invés de construtores
 *
 * Java 8 permitiu métodos estáticos em interfaces
 */
public interface ObjetoInterface {

    // Motivo 4: A classe retornada pode variar de chamada em função dos parâmetros
    // de entrada
    public static ObjetoInterface criarInstanciaOutroObjeto(String nome, String cpf){

        if(nome != null) return Objeto.criarObjetioAPartirDoNome(nome);

        return new OutroObjeto(cpf);
    }
}
