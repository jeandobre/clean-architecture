package br.edu.ufgd.exemplo.util;

import java.util.regex.Pattern;

public class RomanNumeral {

    //Faça assim, inicializando em campo estatico
    //Poderia ser utilizado (não recomendado) a inicialização preguiçosa
    //Não há melhoras de desempenho
    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})" +
            "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    public static boolean isRomanNumeracao(String s){
        return ROMAN.matcher(s).matches();
    }
}
