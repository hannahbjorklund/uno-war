/**
 * Author: Hannah Bjorklund
 */

public class AI {

    /**
     * Returns the first playable card in hand (this is effectively random). If no cards are playable, returns null
     */
    public Card getPlay(Hand hand, CardPile cardPile){
        for(int i = 0; i < hand.getSize(); i++){
            if(cardPile.canPlay(hand.get(i))){
                return hand.get(i);
            }
        }
        return null;
    }

    /**
     * Returns the name of this AI
     */
    public String toString(){return "Random Card AI";}
}
