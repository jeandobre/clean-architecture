package br.exemplo.builder;

/**
 * Classe que exemplifica o uso CORRETO do builder
 * garante a legibilidade, consistencia dos dados
 * e segurança das threads
 *
 * Java Beans
 */
public class NutritionFacts {
    private final int servingSize; // (mL)          exigido
    private final int servings; // (per container)  exigido
    private final int calories; // (per serving)          opcional
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        //Parâmetros exigidos
        private final int servigSize;
        private final int servings;

        //Opcionais
        private int calories = 0; // (per serving)          opcional
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servigSize, int servings) {
            this.servigSize = servigSize;
            this.servings = servings;

            //Validar parâmetros
        }

        public Builder setCalories(int calories) {
            this.calories = calories;
            return this;
        }

        public Builder setFat(int fat) {
            this.fat = fat;
            return this;
        }

        public Builder setSodium(int sodium) {
            this.sodium = sodium;
            return this;
        }

        public Builder setCarbohydrate(int carbohydrate) {
            this.carbohydrate = carbohydrate;
            return this;
        }

        public NutritionFacts build(){

            //validar parâmetros e se incorreto lancar
            // IllegalArgumentException e a mensagem detalhada do(s)
            // atributo(s) incorreto(s).

            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        // (mL)          exigido
        this.servingSize = builder.servigSize;
        this.servings = builder.servings;
        this.calories = builder.calories;
        this.fat = builder.fat;
        this.sodium = builder.sodium;
        this.carbohydrate = builder.carbohydrate;
    }
}
