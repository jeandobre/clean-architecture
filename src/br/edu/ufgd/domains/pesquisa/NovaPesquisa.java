package br.edu.ufgd.domains.pesquisa;

import br.edu.ufgd.domains.pesquisa.domain.PesquisaFactory;

public class NovaPesquisa {

   public void executar(){

       PesquisaFactory fabrica = PesquisaFactory.novaPesquisa("");

       fabrica.validarECriar();

   }

}
