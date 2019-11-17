import java.math.BigInteger;
import java.util.Objects;

public class Exemplo49 {

    private BigInteger strategy;

    /**
     * Retorna uma BigIntegr cujo valor é (this mod m). Esse método
     * difere do método restante na medida em que ele sempre retorna uma
     * BigInteger não negativa
     *
     * O @param m do médulo, deve ser positivo
     * @return seu mod. m
     * Lance uma @throws ArithmeticException se m for menor ou igual a 0
     */
    public BigInteger mod(BigInteger m){

        //Uso incorporado do recurso para a verificação de nulidade no Java
        this.strategy = Objects.requireNonNull(m, "Valor m nulo");

        if(m.signum() <= 0)
            throw new ArithmeticException("Modulus <= 0: " + m);
        //

        return BigInteger.ZERO;
    }

    // Função auxiliar privada para um tipo recursivo
    private static void sort(long[] a, int offset, int length){
        assert a != null; //Lançará uma AssertionError caso falhe
        assert offset >= 0 && offset <= a.length;
        assert length >= 0 && length <= a.length - offset;
        //... faça o cálculo
    }
}
