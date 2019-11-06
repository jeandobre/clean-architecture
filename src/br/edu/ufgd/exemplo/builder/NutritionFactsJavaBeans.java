package br.edu.ufgd.exemplo.builder;

/**
 * Classe que exemplifica o uso ERRADO do builder
 * esta é legível mas não garante sua segurança
 * e consistência
 *
 * Java Beans
 */
public class NutritionFactsJavaBeans {
    private int servingSize = -1; // (mL)          exigido
    private int servings = -1; // (per container)  exigido
    private int calories; // (per serving)          opcional
    private int fat;
    private int sodium;
    private int carbohydrate;

    public NutritionFactsJavaBeans() {
    }

    public void setServingSize(int val) {
        this.servingSize = val;
    }

    public void setServings(int val) {
        this.servings = val;
    }

    public void setCalories(int val) {
        this.calories = val;
    }

    public void setFat(int val) {
        this.fat = val;
    }

    public void setSodium(int val) {
        this.sodium = val;
    }

    public void setCarbohydrate(int val) {
        this.carbohydrate = val;
    }
}
