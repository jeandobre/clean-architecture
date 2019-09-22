package br.edu.ufgd.domains.pesquisa;

import br.edu.ufgd.domains.pesquisa.commands.Dto;
import org.junit.Assert;
import org.junit.Test;
import java.util.GregorianCalendar;

public class NovaPesquisaTest {

    @Test
    public void naoDeveValidarQuandoTituloVazio(){
      //  PesquisaFactory fabrica = PesquisaFactory.novaPesquisa("");
      //  Assert.assertNull(fabrica.validarECriar());

        Dto dto = new Dto();
        dto.titulo = "";

        NovaPesquisa novaPesquisa = new NovaPesquisa();
        Boolean retorno = novaPesquisa.executar(dto);
        Assert.assertFalse("Deve retornar FALSE pois titulo está vazio!", retorno);
    }

    @Test
    public void DeveValidarQuantoDadosCorretos(){
        Dto dto = new Dto();
        dto.titulo = "Avaliação institucional 2019";
        GregorianCalendar data1 = new GregorianCalendar();
        data1.set(2019, GregorianCalendar.JANUARY,13);
        dto.dataInicio = data1.getTime();

        GregorianCalendar data2 = new GregorianCalendar();
        data1.set(2019, GregorianCalendar.FEBRUARY,25);
        dto.dataFim = data2.getTime();

        NovaPesquisa novaPesquisa = new NovaPesquisa();
        Boolean retorno = novaPesquisa.executar(dto);

        Assert.assertTrue("Deve retornar TRUE quando tudo correto!", retorno);
    }

    @Test
    public void naoDeveValidarQuantoPeriodoNulo(){
        Dto dto = new Dto();
        dto.titulo = "Avaliação institucional 2019";

        NovaPesquisa novaPesquisa = new NovaPesquisa();
        Boolean retorno = novaPesquisa.executar(dto);

        Assert.assertFalse("Deve retornar FALSE quando alguma coisa errada!", retorno);
    }

}