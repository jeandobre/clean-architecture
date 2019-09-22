package br.edu.ufgd.domains.pesquisa;

import br.edu.ufgd.domains.pesquisa.commands.Dto;
import br.edu.ufgd.domains.pesquisa.domain.PesquisaFactory;

public class NovaPesquisa {

   public Boolean executar(Dto dto){

       PesquisaFactory fabrica = PesquisaFactory.novaPesquisa(dto.titulo);
       fabrica.noPeriodo(dto.dataInicio, dto.dataFim);

       if(fabrica.validarECriar() == null) return Boolean.FALSE;

       return Boolean.TRUE;
   }

}
