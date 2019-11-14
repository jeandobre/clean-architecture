package br.exemplo.enums;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

//Usando uma EnumMap aninhada para associar os dados aos pares de enum
public enum Phase {
    SOLID, LIQUID, GAS, PLASMA;

    public enum Transition{
        MELT(SOLID, LIQUID),
        FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS),
        CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS),
        DEPOSIT(GAS, SOLID),
        IONIZE(GAS, PLASMA),
        DEIONIZE(PLASMA, GAS);

       private final Phase from;
       private final Phase to;

        Transition(Phase from, Phase to) {
            this.from = from;
            this.to = to;
        }

        //Inicializa a ase de transição da map
        /**
         * Mapeia da fase (fonte) para a o mapa da fase (destino)
         */
        private static final Map<Phase, Map<Phase, Transition>> m =
                Stream.of(values()).collect(groupingBy(t -> t.from,
                        () -> new EnumMap<>(Phase.class),
                        toMap(t -> t.to, t -> t,
                                (x, y) -> y, () -> new EnumMap<>(Phase.class))));
        public static Transition from(Phase from, Phase to){
            return m.get(from).get(to);
        }
    }
}
