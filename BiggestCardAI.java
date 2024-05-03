/**
 * Author: Hannah Bjorklund
 */

public class BiggestCardAI extends AI {

    /**
     * Returns the playable card with the largest rank in the hand. If no cards are playable, returns null.
     */
    @Override
    public Card getPlay(Hand hand, CardPile cardPile){
        Card maxCard = null;

        //This will initialize maxCard with the first card in the hand that can be played
        for(int j = 0; j < hand.getSize(); j++){
            if(cardPile.canPlay(hand.get(j))){
                maxCard = hand.get(j);
            }
        }

        //If there is a better card that can be played (has a larger rank), play that card
        for(int i = 0; i < hand.getSize(); i++){
            if(cardPile.canPlay(hand.get(i))){
                if(hand.get(i).getRankNum() >= maxCard.getRankNum()){
                    maxCard = hand.get(i);
                }
            }
        }
        return maxCard;
    }

    @Override
    public String toString(){return "Biggest Card AI";}
}
