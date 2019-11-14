package domains.pesquisa;

import domains.pesquisa.commands.Dto;
import domains.pesquisa.domain.PesquisaFactory;

public class NovaPesquisa {

   public Boolean executar(Dto dto){

       PesquisaFactory fabrica = PesquisaFactory.novaPesquisa(dto.titulo);
       fabrica.noPeriodo(dto.dataInicio, dto.dataFim);

       if(fabrica.validarECriar() == null) return Boolean.FALSE;

       return Boolean.TRUE;
   }

}
