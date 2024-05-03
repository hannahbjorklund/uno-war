/**
 * Author: Hannah Bjorklund
 */

public class Tournament {
    public static void main(String[] args){
        AI[] aiList = {new AI(), new SmallestCardAI(), new BiggestCardAI()};

        for(int i = 0; i < aiList.length; i++){
            for(int j = 0; j < aiList.length; j++){
                UnoWarMatch match = new UnoWarMatch(aiList[i], aiList[j]);
                System.out.println(aiList[i] + " vs. " + aiList[j] + " winRate: " + match.winRate(5000));
            }
        }
    }
}
