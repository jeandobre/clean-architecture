import java.math.BigInteger;
import java.util.stream.LongStream;

public class Exemplo48 {

    // Pipeline stream para a contagem dos primos - benefícios da paralelização
    static long pi(long n){
        return LongStream.rangeClosed(2, n)
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }

    // Pipeline stream para a contagem dos primos - versão paralela
    static long piParalela(long n){
        return LongStream.rangeClosed(2, n)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }

    public static void main(String[] args){
        piParalela(10_000);
    }
}
