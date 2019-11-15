package br.exemplo.annotation;

import java.util.ArrayList;
import java.util.List;

public class Sample2 {

    @ExceptionTest(ArithmeticException.class)
    public static void m1(){ // o teste deve passar
        int i = 0;
        i = i / i;
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m2(){ // Deve falhar (exceção errada)
        int[] a = new int[0];
        int i = a[1];
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m3(){ // Deve falhar (sem exceção)

    }

    //Código contendo uma anotação com um parâmetro de array
    @ExceptionTest({IndexOutOfBoundsException.class, NullPointerException.class})
    public static void doublyBad(){
        List<String> list = new ArrayList<>();

        // A especificação permite esse método para lançar tanto a
        // IndexOutOfBoundsException como a NullPointerException
        list.addAll(5, null);
    }

    //Código contendo a anotaçãoi que pode ser repetida
    @ExceptionRepetableTest(IndexOutOfBoundsException.class)
    @ExceptionRepetableTest(NullPointerException.class)
    public static void doublyBad2(){

    }
}
