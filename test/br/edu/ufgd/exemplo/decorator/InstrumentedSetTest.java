package br.edu.ufgd.exemplo.decorator;

import br.edu.ufgd.exemplo.hashAndEqual.PhoneNumber;
import org.junit.Test;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class InstrumentedSetTest {


    @Test
    public void exemplosDeUsoDaInstrumentacao(){

        //Instrumentar diretamente
        Set<Date> s = new InstrumentedSet<>(new TreeSet<>());

        //Ou instrimentar uma Set já existente
        Set<PhoneNumber> telefones = new HashSet<>();

        InstrumentedSet<PhoneNumber> iTelefones = new InstrumentedSet<>(telefones);


    }
}
