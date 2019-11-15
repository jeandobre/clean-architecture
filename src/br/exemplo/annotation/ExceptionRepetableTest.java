package br.exemplo.annotation;

import java.lang.annotation.*;

//Tipo de anotação que pode ser repetida
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(ExceptionTestContainer.class)
public @interface ExceptionRepetableTest {
    Class<? extends Exception> value();
}
