package br.exemplo.annotation;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class BigramSemAnotacao {

    private final char first;
    private final char second;

    public BigramSemAnotacao(char first, char second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object b) {
        if(!(b instanceof BigramSemAnotacao)) return false;
        BigramSemAnotacao big = (BigramSemAnotacao) b;
        return big.first == first && big.second == second;
    }

    @Override
    public int hashCode() {
        return 31 * first + second;
    }

    public static void main(String[] args){
        Set<BigramSemAnotacao> s = new HashSet<>();
        for(int i = 0; i < 10; i++)
            for(char ch = 'a'; ch <= 'z'; ch++)
                s.add(new BigramSemAnotacao(ch, ch));

        System.out.println(s.size());
    }
}
