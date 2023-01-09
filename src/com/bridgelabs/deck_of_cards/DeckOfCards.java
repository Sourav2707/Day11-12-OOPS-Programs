package com.bridgelabs.deck_of_cards;

import java.util.*;

public class DeckOfCards {
    Random random = new Random();
    String[] suits = {"Clubs", "Diamond", "Hearts", "Spade"};
    int lengthOfSuits = suits.length;
    String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    int lengthOfRank = rank.length;
    int n = lengthOfSuits * lengthOfRank;
    String[][] cards = new String[lengthOfSuits][lengthOfRank]; //store the set of cards eg: Clubs 2, 3,.... Diamond 2,3....
    public void initializingDeck() {
        for(int i = 0; i < lengthOfSuits; i++) {
            for (int j = 0; j < lengthOfRank; j++) {
                cards[i][j] = suits[i]+" : "+rank[j];
                //1st iteration will be [ Clubs : 2 , Clubs : 3,........Clubs : A ]
                //2nd iteration will be [ Diamond : 2, Diamond: 3,......Diamond : A ]
            }
        }
    }
    public void suffleDeck() {
        // shuffle
        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards[i].length; j++) {
                int x= (int) (Math.random()*10%lengthOfSuits);
                int y= (int) (Math.random()*10%lengthOfRank);
                String temp=cards[i][j];
                cards[i][j]=cards[x][y];
                cards[x][y]=temp;
            }
        }
    }
    int limitOfCards = 9; // setting limit 9 cards per player
    String[] player1 = new String[limitOfCards];
    String[] player2 = new String[limitOfCards];
    String[] player3 = new String[limitOfCards];
    String[] player4 = new String[limitOfCards];
    String[] card = new String[n]; //converting 2d array into 1d array

    public void distributeToPlayers() {
        int index = 0;
        for(int x = 0; x < lengthOfSuits; x++) {
            for(int y = 0; y < lengthOfRank; y ++) {
                card[index++] = cards[x][y];
            }
        }
        int j = 0;//3,7,11,15,19,23,27,31,35

        for(int i = 0; i < limitOfCards; i++)
        {
            player1[i] = card[j++];//0,4....//providing cards one by one
            player2[i] = card[j++];//1,5....
            player3[i] = card[j++];//2,6....
            player4[i] = card[j++];//3,7....
        }
        System.out.println("Player 1 have "+Arrays.toString(player1));
        System.out.println("Player 2 have "+Arrays.toString(player2));
        System.out.println("Player 3 have "+Arrays.toString(player3));
        System.out.println("Player 4 have "+Arrays.toString(player4));
    }
}
