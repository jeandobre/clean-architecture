package br.exemplo;

import java.util.Date;

// Classe de período de tempo correta
// faz cópias defensivas de parâmetros
public final class Period {
    private final Date start;
    private final Date end;

    /**
     * @param start inicia o começo do período
     * @param end termina o final do período; não deve preceder o início
     * @throws IllegalArgumentException se start > end
     * @throws NullPointerException se start ou end for nulo
     */
    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());

        if(this.start.compareTo(this.end) > 0) {
            throw new IllegalArgumentException(start + " after " + end);
        }
    }

    //Correção conta ataque nos getters
    public Date start() {
        return new Date(start.getTime());
    }

    public Date end(){
        return new Date(end.getTime());
    }

    // Segundo ataque no interior de uma instância do Period
    public void exemploDeAtaqueInterno(){
        Date start = new Date();
        Date end = new Date();
        Period p = new Period(start, end);
        p.end().setYear(78); //Altere os internos de p!
    }
}
