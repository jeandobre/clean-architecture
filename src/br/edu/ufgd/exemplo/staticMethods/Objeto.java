package br.edu.ufgd.exemplo.staticMethods;

/**
 * Classe para exemplificar os motivos de usar métodos estáticos
 * ao invés de construtores
 *
 */
public class Objeto implements ObjetoInterface {

    private String nome;
    private static Objeto instancia;

    // Motivo 1: O método tem nome
    public static Objeto criarObjetioAPartirDoNome(String nome){
        Objeto objeto = new Objeto();
        objeto.nome = nome;
        return objeto;
    }

    // Motivo 2: Não precisam criar um objeto novo sempre que invocado
    public static Objeto criarInstanciaSeNaoExistir(){
        if(instancia != null)
            instancia = new Objeto();
        return instancia;
    }

    // Motivo 3: Podem retornar um objeto de qualquer subtipo do próprio tipo
    public static ObjetoInterface criarInstanciaOutroObjeto(String cpf){
        return new OutroObjeto(cpf);
    }

    // Motivo 4: na interface ObjetoInteface.java

    // Motivo 5: Não precisa existir a classe do objeto retornado quando a
    // classe contém o método de escrita


    // Problemas: 1 - dificil de ser encontrado pelos programadores
    //            2 - classes sem construtores públicos ou protegidos não podem
    //                  ser divididas em subclasses.

    private Objeto() {
    }
}
