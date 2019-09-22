package br.edu.ufgd;

import br.edu.ufgd.domains.pesquisa.domain.PesquisaFactory;
import org.junit.Assert;
import org.junit.Test;

public class teste{

    @Test
    public void testar(){
        PesquisaFactory fabrica = PesquisaFactory.novaPesquisa("");
        Assert.assertNull(fabrica.validarECriar());
    }
}