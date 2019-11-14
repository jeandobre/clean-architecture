package br.exemplo.objetosDesnecessarios;

import br.exemplo.objetos_desnecesarios.ExemploCorreto;
import br.exemplo.objetos_desnecesarios.ExemploRuim;
import org.junit.Test;

public class ExemploTest {


    @Test
    public void tempoChamadaExemploCorreto(){
        ExemploCorreto exemplo = new ExemploCorreto();
        for(int i = 0; i < 10000000; i++){
            exemplo.isBabyBoomer();
        }
    }

    @Test
    public void tempoChamadaExemploRuim(){
        ExemploRuim exemplo = new ExemploRuim();
        for(int i = 0; i < 10000000; i++){
            exemplo.isBabyBoomer();
        }
    }

}
