package br.exemplo;

import java.util.Date;

// Classe de período de tempo imutável quebrada
public final class PeriodRuim {
    private final Date start;
    private final Date end;

    /**
     * @param start inicia o começo do período
     * @param end termina o final do período; não deve preceder o início
     * @throws IllegalArgumentException se start > end
     * @throws NullPointerException se start ou end for nulo
     */
    public PeriodRuim(Date start, Date end) {
        if(start.compareTo(end) > 0)
            throw new IllegalArgumentException(start + " after " + end);

        this.start = start;
        this.end = end;
    }

    public Date start() {
        return start;
    }

    public Date end(){
        return end;
    }

    // Ataque os internos de uma instância do período
    public void exemploDeAtaque(){
        Date start = new Date();
        Date end = new Date();
        PeriodRuim p = new PeriodRuim(start, end);
        end.setYear(78); // Altere os internos de p!

        //Ataque TOCTOU
    }
}
