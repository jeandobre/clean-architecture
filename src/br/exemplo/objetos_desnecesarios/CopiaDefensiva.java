package br.exemplo.objetos_desnecesarios;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class CopiaDefensiva {

    public static void main(String[] args){

        int idade = 10;
        String nome = "Jean";
        Date data = new Date();

        Pessoa pessoa = new Pessoa(nome, idade, data)
                .setTelfone("(67) 99223-6864");

        System.out.println(pessoa);

        idade = 20;
        nome = "Paulo";
        data.setYear(2020);
        pessoa.getTelefones().add("(67) 99221-9242");

        System.out.println(pessoa);

        Integer idade2 = pessoa.idade();
        idade2 = 30;

        System.out.println(pessoa);

        Set<String> telefones = pessoa.getTelefones();
        telefones.add("Novo telefone");
        System.out.println(pessoa.getTelefones());

    }
}
