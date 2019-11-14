package br.exemplo.annotation;

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
}
