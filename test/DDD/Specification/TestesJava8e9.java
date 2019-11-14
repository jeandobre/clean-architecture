package DDD.Specification;

import br.exemplo.util.RomanNumeral;
import org.junit.Assert;
import org.junit.Test;

public class TestesJava8e9  {

    @Test
    public void testarSuplier(){
      //  Supplier<? extends PhoneNumber> supridor;
    }

    @Test
    public void nuncaFacaIsso(){
        String errado = new String("biquine"); //DONT DO THIS
        String correto = "biquine";
    }

    //função para verificar se é um número romano válido
    //Péssimo uso de String.matches para uso repetido
    static boolean isRomanNumeracao(String s){
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})" +
                "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    @Test
    public void testarNumeraisFormaIncorreta(){
        for(int i = 0; i< 10000; i++) {
           Assert.assertTrue(isRomanNumeracao("XXXVIII"));
        }
    }

    //Uso correto, visando reúso do objeto trabalhoso para melhorar o desempenho
    @Test
    public void testarNumeraisFormaCorreta(){
        for(int i = 0; i< 10000; i++) {
            Assert.assertTrue(RomanNumeral.isRomanNumeracao("XXXVIII"));
        }
    }

}
