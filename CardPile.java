/**
 * Author: Hannah Bjorklund
 */

public class CardPile {
    private Card topCard;
    private int numCards;

    /**
     * Sets topCard with the given card. This top card represents the card pile.
     */
    public CardPile(Card card){
        topCard = card;
        numCards++;
    }

    /**
     * Returns true if the given card can be played on the card pile (has an equal or higher rank, or is the same suit)
     */
    public boolean canPlay(Card card){
        return (card.getRankNum() >= topCard.getRankNum() || card.getSuitNum() == topCard.getSuitNum());
    }

    /**
     * If the card is playable, adds the card to the card pile. new card becomes topCard, and numCards increases by 1
     * If a card is null or the card cannot be played, prints an error message
     */
    public void play(Card card){
        if(card != null) {
            if (canPlay(card)) {
                topCard = card;
                numCards++;
            } else {
                System.out.println("Illegal move detected!");
            }
        } else {
            System.out.println("Illegal move detected!");
        }
    }

    public int getNumCards(){return numCards;}

    public Card getTopCard(){return topCard;}
}
