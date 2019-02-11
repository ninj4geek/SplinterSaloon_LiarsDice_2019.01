import java.util.List;

public class Main {
    public static void main(String[] args) {

        Text.introductionText();
        List totalBet;
        int diceCount = 5;
        int playerCount = 2;
        Player player1 = new Player(diceCount);
        Player player2 = new Player(diceCount);

        while (playerCount > 1){  // Gameplay loop //
            totalBet = Functions.playRound(player1, player2);

            int betQty = Functions.retrieveBetQuantity();
            int faceValue = Functions.retrieveBetFaceValue();

            if (Functions.betCompare(betQty, faceValue, totalBet)){
                System.out.println("\nExcellent bet!, took a die from Player 2");
                player1.gainADie();
                player2.loseADie();
            } else {
                System.out.println("\nBad guess, lose a die to Player 2");
                player2.gainADie();
                player1.loseADie();
            }

            Text.showDiceCount(player1,player2);

            if (player1.getDiceCount() == 0){
                playerCount--;
                System.out.println("\n\nPLAYER 1 ELIMINATED\n\n");
            }
            if (player2.getDiceCount() == 0){
                playerCount--;
                System.out.println("\n\nPLAYER 2 ELIMINATED\n\n");
            }
        }
    }
}