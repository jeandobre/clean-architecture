package domains.pesquisa.domain;

import java.util.Date;
import java.util.List;

class Pesquisa extends Entity {

    private String titulo;
    private String descricao;

    private Date dataInicio;
    private Date dataFim;

    private List<String> objetos;

    public Pesquisa(String titulo) {
        this.titulo = titulo;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    @Override
    public Boolean validate() {
        if(titulo == null || titulo.isEmpty()) return Boolean.FALSE;

        if(dataInicio == null || dataFim == null) return Boolean.FALSE;

        if(dataInicio.after(dataFim)) return Boolean.FALSE;

        return Boolean.TRUE;
    }
}
