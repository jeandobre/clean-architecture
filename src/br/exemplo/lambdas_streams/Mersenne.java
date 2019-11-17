package br.exemplo.lambdas_streams;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;

public class Mersenne {

    static Stream<BigInteger> primes(){
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }

    public static void main(String[] args){
       //Errado esse aqui, pois o pow é mapeado mas o filter não acessa os valores
        primes().map(p -> TWO.pow(p.intValueExact())
                .subtract(ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(System.out::println);

        //Correto
        primes().map(p -> TWO.pow(p.intValueExact())
                .subtract(ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(mp -> System.out.println(mp.bitLength() + ":" + mp));
    }
}
