/**
 * Author: Hannah Bjorklund
 */

import java.util.Random;

public class Deck{
    private Card[] cardDeck;
    private int remainingCards;

    /**
     * Creates a new deck of 52 Cards. Loops over all rank and suit values so all cards are unique (a standard deck),
     * then shuffles it
     */
    public Deck(){
        int k = 0;
        cardDeck = new Card[52];
        while(k < 52){
            for(int i = 1; i < 5; i++){
                for(int j = 1; j < 14; j++){
                    cardDeck[k] = new Card(j, i);
                    k++;
                }
            }
        }
        shuffle();
    }

    /**
     * Shuffles a deck by switching a card in the deck, starting with the last card, with a card from a random index.
     * Sets remaining cards to 52 (for the purpose of when the deck runs out and must be re-shuffled)
     */
    public void shuffle(){
        Random rand = new Random();
        for(int i = cardDeck.length-1; i >= 1; i--){
            int j = rand.nextInt(i+1);
            Card tmp = cardDeck[i];
            cardDeck[i] = cardDeck[j];
            cardDeck[j] = tmp;
        }
        remainingCards = 52;
    }

    public int cardsRemaining(){return remainingCards;}

    /**
     * Returns true if there are no remaining cards in the deck
     */
    public boolean isEmpty(){return cardsRemaining() == 0;}

    /**
     * Returns the last card in the deck. Since the deck is shuffled, the drawn card will be random. After drawing,
     * remainingCards goes down by one. If the deck is empty, shuffles the deck first, then draws a card.
     */
    public Card draw(){
        if(isEmpty()){
            shuffle();
        }
        remainingCards--;
        return cardDeck[remainingCards];
    }
}
