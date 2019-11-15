package br.exemplo.annotation;


import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//Programa para processar anotações marcadoras
public class RunTests {
    public static void main(String[] args) throws Exception{
        int tests = 0;
        int passed = 0;
        //Class<?> testClass = Class.forName(args[0]);
        Class<?> testClass = Class.forName("test.br.exemplo.annotation.Sample2.java");
        for(Method m : testClass.getDeclaredMethods()){
            if(m.isAnnotationPresent(ExceptionRepetableTest.class)
            || m.isAnnotationPresent(ExceptionTestContainer.class)){
                tests++;
                try{
                    m.invoke(null);
                    System.out.printf("Test %s failed: no exception%n", m);
                } catch (InvocationTargetException wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    int oldPassed = passed;
                    ExceptionRepetableTest[] excTests =
                            m.getAnnotationsByType(ExceptionRepetableTest.class);
                    for (ExceptionRepetableTest excTest : excTests) {
                        if (excTest.value().isInstance(exc)) {
                            passed++;
                            break;
                        }
                    }
                    if (passed == oldPassed)
                        System.out.printf("Test %s failed: expected %s %n", m, exc);
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
    }
}
