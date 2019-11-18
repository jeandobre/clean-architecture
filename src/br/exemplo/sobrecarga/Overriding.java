package br.exemplo.sobrecarga;

import java.util.List;

//Forma correta de override o método de uma classe
public class Overriding {
    public static void main(String[] args){
        List<Wine> wineList = List.of(new Wine(), new SparklingWine(), new Champagne());
        for(Wine wine  : wineList)
            System.out.println(wine.name());
    }
}
