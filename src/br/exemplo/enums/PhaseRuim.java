package br.exemplo.enums;

//Usando o ordinal() para indexar uma matriz de arrays - NÃO FAÇA ISSO!
public enum PhaseRuim {
    SOLID, LIQUID, GAS;

    public enum Transition{
        MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;

        private static final Transition[][] TRANSITIONS = {
                { null, MELT, SUBLIME },
                { FREEZE, null, BOIL},
                { DEPOSIT, CONDENSE, null}
        };

        //Retorna a transição de fase de uma fase para outra
        public static Transition from(PhaseRuim from, PhaseRuim to){
            return TRANSITIONS[from.ordinal()][to.ordinal()];
        }
    }
}
