package br.edu.ufgd.exemplo.genericos;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// Padrão contêiner heterogêneo typesafe - implementacao
public class Favorites {
    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance){
        favorites.put(Objects.requireNonNull(type), type.cast(instance));
    }
    public <T> T getFavorite(Class<T> type){
        return type.cast(favorites.get(type));
    }

    // Uso da asSubclass para fazer o cast seguro de um tipo de token limitado
    static Annotation getAnnotation(AnnotatedElement element, String annotationTypeName){
        Class<?> annotationType = null; //Tipo de token ilimitado
        try{
            annotationType = Class.forName(annotationTypeName);
        } catch (Exception ex){
            throw new IllegalArgumentException(ex);
        }
        return element.getAnnotation(annotationType.asSubclass(Annotation.class));
    }
}
