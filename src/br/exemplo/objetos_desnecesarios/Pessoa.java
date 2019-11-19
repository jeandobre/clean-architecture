package br.exemplo.objetos_desnecesarios;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Pessoa {

    private Integer idade;
    private String nome;
    private Set<String> telefones;

    private Boolean passou = false;

    Pessoa(String nome, Integer idade) {
        this.idade = idade;
        this.nome = nome;

        this.telefones = new HashSet<>();

        if (this.idade >= 18) passou = true;
    }

    Pessoa setTelfone(String telefone){
        telefones.add(telefone);
        return this;
    }

    public Integer idade() {
        return idade;
    }

    public String nome() {
        return nome;
    }

    public Boolean passou() {
        return passou;
    }

    public Set<String> getTelefones() {
        return telefones;
    }

    @Override
    public String toString() {
        return nome + ":" + idade + "(" + passou + ")";
    }
}