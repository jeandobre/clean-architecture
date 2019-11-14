package br.exemplo.objetos_desnecesarios;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/***
 * Desperdício de memoria e tempo de xecução
 */
public class ExemploRuim {

    private final Date birthDate = new Date();

    public boolean isBabyBoomer(){
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomStart = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomEnd = gmtCal.getTime();

        return birthDate.compareTo(boomStart) >= 0 &&
                birthDate.compareTo(boomEnd) < 0;

    }
}
