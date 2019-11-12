package br.edu.ufgd.exemplo.objetos_desnecesarios;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/***
 * Desperdício de memoria e tempo de xecução
 */
public class ExemploCorreto {

    private final Date birthDate = new Date();

    private static final Date BOOM_START;
    private static final Date BOOM_END;

    static {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_START = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_END = gmtCal.getTime();
    }
        
    public boolean isBabyBoomer(){

        return birthDate.compareTo(BOOM_START) >= 0 &&
                birthDate.compareTo(BOOM_END) < 0;

    }
}
