package br.edu.ufgd.domains.pesquisa.domain;

import java.util.Date;

public class PesquisaFactory {

    private Pesquisa pesquisa;

    private PesquisaFactory() {
    }

    public static PesquisaFactory novaPesquisa(String titulo){
        PesquisaFactory fabrica = new PesquisaFactory();
        fabrica.pesquisa = new Pesquisa(titulo);
        return fabrica;
    }

    public PesquisaFactory noPeriodo(Date dataInicio, Date dataFim){

        pesquisa.setDataInicio(dataInicio);
        pesquisa.setDataFim(dataFim);

        return this;
    }

    public Pesquisa validarECriar(){

        if (!pesquisa.validate()) {
            return null;
        }
        return pesquisa;
    }

}
