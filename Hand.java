/**
 * Author: Hannah Bjorklund
 */

public class Hand extends Deck {
    private Card[] cardHand;

    /**
     * Creates a list of Cards representing a hand of the specified size. Draws cards until the hand is that size.
     */
    public Hand(Deck deck, int size){
        cardHand = new Card[size];
        for(int i = 0; i < size; i++){
            cardHand[i] = deck.draw();
        }
    }

    public int getSize(){return cardHand.length;}

    /**
     * Returns the card in the hand at the given index. If the hand index is out of range, returns the first card in hand
     */
    public Card get(int i){
        if(i < 0 || i >= cardHand.length){
            System.out.println("Invalid hand index!");
            return cardHand[0];
        } else {
            return cardHand[i];
        }
    }

    /**
     * Removes the specified card from the hand, then returns true. If the card is not in the hand, returns false
     */
    public boolean remove(Card card){
        for(int i = 0; i < cardHand.length; i++){
            if(cardHand[i].getRankNum() == card.getRankNum() && cardHand[i].getSuitNum() == card.getSuitNum()){
                cardHand[i] = draw();
                return true;
            }
        }
        return false;
    }
}
