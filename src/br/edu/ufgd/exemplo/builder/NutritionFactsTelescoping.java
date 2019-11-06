package br.edu.ufgd.exemplo.builder;

/**
 * Classe que exemplifica o uso ERRADO do builder
 * esta classe não é escalável
 *
 * Telescoping constructor
 *
 */
public class NutritionFactsTelescoping {
    private final int servingSize; // (mL)          exigido
    private final int servings; // (per container)  exigido
    private final int calories; // (per serving)    opcional
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public NutritionFactsTelescoping(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }

    public NutritionFactsTelescoping(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories, 0);
    }

    public NutritionFactsTelescoping(int servingSize, int servings, int calories, int fat) {
        this(servingSize, servings, calories, fat, 0);
    }

    public NutritionFactsTelescoping(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }

    public NutritionFactsTelescoping(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }
}
