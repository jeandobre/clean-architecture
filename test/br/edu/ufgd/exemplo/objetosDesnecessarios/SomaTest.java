package br.edu.ufgd.exemplo.objetosDesnecessarios;

import br.edu.ufgd.exemplo.objetosDesnecesarios.SomaLenta;
import br.edu.ufgd.exemplo.objetosDesnecesarios.SomaRapida;
import org.junit.Test;

public class SomaTest {

    @Test
    public void testarSomaRapida(){

        SomaRapida soma = new SomaRapida();
        soma.processar();

    }

    @Test
    public void testarSomaLenta(){

        SomaLenta soma = new SomaLenta();
        soma.processar();

    }

}
