package br.exemplo.objetos_desnecesarios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NullAble {

    private final List<String> cheesesInStock = new ArrayList<>();

    // Retorna null para indicar uma coleção vazia. NUNCA FAÇA ISSO!
    public List<String> getCheses(){
        return cheesesInStock.isEmpty() ? null
                : new ArrayList<>(cheesesInStock);
    }

    // O jeito ceto para devolver uma coleção possivelmente vazia
    public List<String> getCheeses(){
        return new ArrayList<>(cheesesInStock);
    }

    // Otimização - evita a alocação de coleções vazias
    public List<String> getCheesesOtimizado(){
        return cheesesInStock.isEmpty() ? Collections.emptyList()
                : new ArrayList<>(cheesesInStock);
    }

    // O jeito certo para retornar um array possivelmente vazio
    public String[] getCheesesArray(){
        return cheesesInStock.toArray(new String[0]);
    }

    // Otimização - evita a alocação de arrays vazios
    private static final String[] EMPTY_CHEESE_ARRAY = new String[0];

    public String[] getCheesesArrayStatic(){
        return cheesesInStock.toArray(EMPTY_CHEESE_ARRAY);
    }

    // NÃO FACA ISSO - PRE ALOCAR O ARRAY PREJUDICA O DESEMPENHO
    public String[] getCheesesArrayIncorreto(){
        return cheesesInStock.toArray(new String[cheesesInStock.size()]);
    }
}
