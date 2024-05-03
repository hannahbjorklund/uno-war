/**
 * Author: Hannah Bjorklund
 */

public class UnoWarMatch {
    private AI AI1;
    private AI AI2;


    /**
     * Sets AI1 and AI2, which will play against each other
     */
    public UnoWarMatch(AI ai1, AI ai2){
        AI1 = ai1;
        AI2 = ai2;
    }

    /**
     * Plays a game of UnoWarMatch. The deck is created, and each AI gets a hand. The first card is drawn for the card
     * pile. Then, AI1 plays a card. The card is added to the card pile, and removed from the hand.
     * The AI draws a new card from the deck. AI2 does the same, then it repeats. The first AI to play "null" card loses.
     * When an AI wins a round, they play first in the next round. Rounds are played until an AI gets 10 wins.
     * Returns true if AI1 wins the game, and false if AI2 wins.
     */
    public boolean playGame(){
        Deck deck = new Deck();
        Hand hand1 = new Hand(deck, 5);
        Hand hand2 = new Hand(deck, 5);
        CardPile pile = new CardPile(deck.draw());
        int ai1Wins = 0, ai2Wins = 0;
        int goesFirst = 1;

        while(ai1Wins < 10 && ai2Wins < 10){
            if(goesFirst == 1){
                Card choice1 = AI1.getPlay(hand1, pile);
                if(choice1 == null){
                    ++ ai2Wins;
                    goesFirst = 2;
                }
                else{
                    pile.play(choice1);
                    hand1.remove(choice1);
                    hand1.draw();
                    Card choice2 = AI2.getPlay(hand2, pile);
                    if(choice2 == null){
                        ++ ai1Wins;
                        goesFirst = 1;
                    }
                    else{
                        pile.play(choice2);
                        hand2.remove(choice2);
                        hand2.draw();
                    }
                }
            }
            else if(goesFirst == 2){
                Card choice2 = AI2.getPlay(hand2, pile);
                if(choice2 == null){
                    ++ ai1Wins;
                    goesFirst = 1;
                }
                else{
                    pile.play(choice2);
                    hand2.remove(choice2);
                    hand2.draw();
                    Card choice1 = AI1.getPlay(hand1, pile);
                    if(choice1 == null){
                        ++ ai2Wins;
                        goesFirst = 2;
                    }
                    else{
                        pile.play(choice1);
                        hand1.remove(choice1);
                        hand1.draw();
                    }
                }
            }
        }
        return ai1Wins > ai2Wins;
    }

    /**
     * Returns the win rate of AI1 vs AI2
     */
    public double winRate(int nTrials){
        double ai1Wins = 0, ai2Wins = 0;

        for(int i = 0; i < nTrials; i++){
            if(playGame()){
                ai1Wins++ ;
            }
            else {
                ai2Wins++;
            }
        }
        return (ai1Wins/(ai2Wins+ai1Wins));
    }
}
