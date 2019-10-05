package br.edu.ufgd.exemplo.services;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Services {

    private Services(){}

    private static final Map<String, Provider> providers =
            new ConcurrentHashMap<>();

    public static final String DEFALT_PROVIDER_NAME = "<def>";

    public static void registerDefaultProvider(Provider provider){
        registerProvider(DEFALT_PROVIDER_NAME, provider);
    }

    private static void registerProvider(String name, Provider provider) {
        providers.put(name, provider);
    }

    public static Service newInstance(){
        return newInstance(DEFALT_PROVIDER_NAME);
    }

    public static Service newInstance(String name){
        Provider provider = providers.get(name);
        if(provider == null) throw new IllegalArgumentException("No provider registered with name: " + name);

        return provider.newService();
    }

    /**
     * Apenas um teste, suprimindo a verbosidade do HashMap
     * Nem compensa mais no Java 8 fazer isso.
     */
    /*
    public static <K, V> HashMap<K, V> newInstance(){
        return new HashMap<>();
    }
    */
}
