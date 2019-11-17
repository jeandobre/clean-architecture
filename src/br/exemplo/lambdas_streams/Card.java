package br.exemplo.lambdas_streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Card {
    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    //Calculo iterativo do produto cartesiano
    private static List<Card> newDeck1(){
        List<Card> result = new ArrayList<>();
        for(Suit suit : Suit.values())
            for(Rank rank: Rank.values())
                result.add(new Card(rank, suit));

        return result;
    }

    //Cálculo do produto cartesiano baseado em uma stream
    private static List<Card> newDeck(){
     return Stream.of(Suit.values())
             //flatMap achata a primeira stream com a segunda
        .flatMap(suit -> Stream.of(Rank.values())
        .map(rank -> new Card(rank, suit)))
        .collect(toList());
    }

}
