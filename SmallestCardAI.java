/**
 * Author: Hannah Bjorklund
 */

public class SmallestCardAI extends AI{

    /**
     * Returns the playable card with the smallest rank in the hand. If no cards are playable, returns null.
     */
    @Override
    public Card getPlay(Hand hand, CardPile cardPile){
        Card minCard = null;

        //This will initialize minCard with the first card in the hand that can be played
        for(int j = 0; j < hand.getSize(); j++){
            if(cardPile.canPlay(hand.get(j))){
                minCard = hand.get(j);
            }
        }

        //If there is a better card that can be played (has a smaller rank), play that card
        for(int i = 0; i < hand.getSize(); i++){
            if(cardPile.canPlay(hand.get(i))){
                if(hand.get(i).getSuitNum() == cardPile.getTopCard().getSuitNum() && hand.get(i).getRankNum() <= minCard.getRankNum()){
                    minCard = hand.get(i);
                } else if(hand.get(i).getRankNum() <= minCard.getRankNum()){
                    minCard = hand.get(i);
                }
            }
        }
        return minCard;
    }

    @Override
    public String toString(){return "Smallest Card AI";}
}
