package br.edu.ufgd.exemplo.builder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

//Padrão Builder para Hierarquia de classe
public abstract class Pizza {
    public enum Topping {
        HAM, MUSHROOM, ONION, PEPPER, SOUSAGE;
    }
    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping, "Objeto não pode ser nulo!"));
            return self();
        }

        abstract Pizza build();

        //As subClasses devem sobrescrever esse método para retornar "essa
        // classe protegida
        abstract T self();
    }
    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }
}