package com.bridgelabs.deck_of_cards;

public class Main {
    public static void main(String[] args) {
        DeckOfCards deckOfCards = new DeckOfCards();
        deckOfCards.initializingDeck();
        deckOfCards.suffleDeck();
        deckOfCards.distributeToPlayers();
    }
}
