package br.edu.ufgd.exemplo.hashAndEqual;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class PhoneNumberTest {

    @Test
    public void deveEncontrarNullPorFaltaDoMetodoHash(){
        Map<PhoneNumber, String> lista = new HashMap<>();
        lista.put(new PhoneNumber(67, 99221, 9242), "Jean");
        lista.put(new PhoneNumber(67, 99223, 6864), "Sheila");

        String pessoaEncontrada = lista.get(new PhoneNumber(67, 99221, 9242));

        Assert.assertNull(pessoaEncontrada);
    }

    @Test
    public void deveEncontrarCorretamentePorTerOMetodoHash(){
        Map<PhoneNumberComHashCode, String> lista = new HashMap<>();
        lista.put(new PhoneNumberComHashCode(67, 99221, 9242), "Jean");
        lista.put(new PhoneNumberComHashCode(67, 99223, 6864), "Sheila");

        String pessoaEncontrada = lista.get(new PhoneNumberComHashCode(67, 99221, 9242));

        Assert.assertNotNull(pessoaEncontrada);
        Assert.assertEquals("Jean", pessoaEncontrada);
    }

    @Test
    public void devemSerIguaisPeloMetodoEqual(){
        PhoneNumber telefoneJean = new PhoneNumber(67, 99221, 9242);

        PhoneNumber telefoneJean2 = new PhoneNumber(67, 99221, 9242);

        Assert.assertEquals(telefoneJean, telefoneJean2);

    }

    @Test
    public void devemTerHashDiferentes(){
        PhoneNumber telefoneJean = new PhoneNumber(67, 99221, 9242);

        PhoneNumber telefoneJean2 = new PhoneNumber(67, 99221, 9242);

        Assert.assertNotEquals(telefoneJean.hashCode(), telefoneJean2.hashCode());
    }

    @Test
    public void devemTerHashIguas(){
        PhoneNumberComHashCode telefoneJean = new PhoneNumberComHashCode(67, 99221, 9242);
        //System.out.println(telefoneJean.hashCode());
        PhoneNumberComHashCode telefoneJean2 = new PhoneNumberComHashCode(67, 99221, 9242);
        //System.out.println(telefoneJean2.hashCode());
        Assert.assertEquals(telefoneJean.hashCode(), telefoneJean2.hashCode());
    }
}
