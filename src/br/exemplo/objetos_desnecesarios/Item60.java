package br.exemplo.objetos_desnecesarios;

import java.math.BigDecimal;

/**
 * Programa que calcula quantos items comprar de 0.10, 0.20, 0.30 até 1.0
 */
public class Item60 {

    //Quebrado usa o ponto flutuante
    public static void main(String[] args){

        calculoErrado();

        calculoCorreto();

    }

    public static void calculoErrado(){
        System.out.println(1.03 - 0.42);
        System.out.println(1.00 - 9 * 0.10);

        double funds = 1.00;
        int itemsBought = 0;
        for(double price = 0.10; funds >= price; price += 0.10){
            funds -= price;
            itemsBought++;
        }
        System.out.println(itemsBought + " items bought.");
        System.out.println("Change: $" + funds + " cents");
    }

    //Usando BigDecimal ou int ou long
    public static void calculoCorreto(){
        final BigDecimal TEN_CENTS = new BigDecimal(".10");

        int itemsBought = 0;
        BigDecimal funds = new BigDecimal("1.00");
        for(BigDecimal price = TEN_CENTS; funds.compareTo(price) >= 0;
            price = price.add(TEN_CENTS)){
            funds = funds.subtract(price);
            itemsBought++;
        }
        System.out.println(itemsBought + " items bought.");
        System.out.println("Money left over: $" + funds);
    }

}
