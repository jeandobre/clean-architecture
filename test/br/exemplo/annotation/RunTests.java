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
            if(m.isAnnotationPresent(Test.class)){
                tests++;
                try{
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException wrappedExc){
                    Throwable exc = wrappedExc.getCause();
                    System.out.println(m + " failed: " + exc);
                } catch (Exception ex){
                    System.out.println("Invalid @test: " + m);
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
    }
}
