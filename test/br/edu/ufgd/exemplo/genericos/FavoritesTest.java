package br.edu.ufgd.exemplo.genericos;

import org.junit.Test;

public class FavoritesTest {

    @Test
    public void teste(){
        Favorites f = new Favorites();
        f.putFavorite(String.class, "java");
        f.putFavorite(Integer.class, 0xcafebabe);
        f.putFavorite(Class.class, Favorites.class);

        String favoriteString = f.getFavorite(String.class);
        int favoriteInteger = f.getFavorite(Integer.class);
        Class<?> favoriteClass = f.getFavorite(Class.class);

        System.out.printf("%s %x %s%n", favoriteString, favoriteInteger, favoriteClass.getName());
    }
}
