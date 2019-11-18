package br.exemplo.sobrecarga;

import java.math.BigInteger;
import java.util.*;

//Quebrado - não funciona corretamente
public class CollectionClassifier {
    // errado
    public static String classify(Set<?> s){
        return "Set";
    }

    //errado
    public static String classify(List<?> lst){
        return "List";
    }

    //errado
    public static String classify(Collection<?> c){
        return "Unknown Collection";
    }

    //correto
    public static String classifyCorreto(Collection<?> c){
        return c instanceof Set ? "Set" : c instanceof List ? "List" : "Collection";
    }

    public static void main(String[] args){
        Collection<?>[] collections = {
          new HashSet<String>(),
          new ArrayList<BigInteger>(),
          new HashMap<String, String>().values()
        };
        for(Collection<?> c : collections)
            System.out.println(classifyCorreto(c));
    }
}
