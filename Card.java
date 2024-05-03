/**
 * Author: Hannah Bjorklund
 */

public class Card {
    private int cardRank;
    private int cardSuit;
    private static String[] rankNames = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                                         "Jack", "Queen", "King"};
    private static String[] suitNames = {"Spades", "Hearts", "Clubs", "Diamonds"};

    /**
     * Sets the cardRank and cardSuit to the specified rank and suit. If the rank or suit is out of range, sets to 1.
     */
    public Card(int rank, int suit){
        if(suit > 4 || suit < 1 || rank < 1 || rank > 13){
            System.out.println("Invalid card");
            cardRank = 1;
            cardSuit = 1;
        }
        else{
            cardRank = rank;
            cardSuit = suit;
        }
    }

    public int getRankNum(){return cardRank;}

    public int getSuitNum(){return cardSuit;}

    public String getRankName(){return rankNames[cardRank-1];}

    public String getSuitName(){return suitNames[cardSuit-1];}

    /**
     * Returns a string representing the name of a card. For example, "Ace of Spades"
     */
    public String toString(){return getRankName() + " of " + getSuitName();}

    /**
     * Returns true if two cards are equal to each other. This means that they have the same rank and same suit. Else,
     * returns false
     */
    public boolean equals(Object other){
        if(this == other){
            return true;
        }
        if(other == null){
            return false;
        }
        else if(other instanceof Card){
            Card c = (Card) other;
            return (this.cardRank == c.cardRank && this.cardSuit == c.cardSuit);
        }
        else{
            return false;
        }
    }
}
