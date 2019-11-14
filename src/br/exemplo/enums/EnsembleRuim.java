package br.exemplo.enums;


// Abuso do ordinal para derivar um valor associado - NÃO FAÇA ISSO
public enum EnsembleRuim {
    SOLO, DUET, TRIO, QUARTET, QUINTET,
    SEXTET, SEPTET, OCTET, NONET, DECTET;

    public int numberOfMusicians(){
        return ordinal() + 1;
    }
}
