import java.util.ArrayList;
import java.util.Scanner;

public class PiratesDiceMain {
    public static void main(String[] args) {
        //***********************Introduction and Rules*******************************//
        System.out.println("\n\n******Arrr, this be Liar's Dice******");
        System.out.println("\n\nEach player will receive 5 dice");
        System.out.println("All dice will be thrown under your cups");

        System.out.println("\nBids are made against all dice in play, on the");
        System.out.println("quantity of dice of a face value.");
        System.out.println("If you bid correctly, you win a die from the computer.");
        System.out.println("If you guessed wrong, the computer gets one of YOUR dice.");
        System.out.println("\n\nLast one with dice wins.");

        System.out.println("\nPlayer 1 is you, Player 2 is the computer. ");
        int diceCount = 5;
        int playerCount = 2;

        DiceCup player1 = new DiceCup(diceCount);
        DiceCup player2 = new DiceCup(diceCount);

        //player#Hand is the dice throw result
        ArrayList <Integer> player1Hand;
        ArrayList <Integer> player2Hand;

        //player#sumBet shows qty of 1,2,3,4,5,6's thrown per cup
        ArrayList <Integer> p1sumBet;
        ArrayList <Integer> p2sumBet;
        ArrayList <Integer> totalBet;

       //Main gameplay loop
       while (playerCount > 1){

           //throw dice-------------------------------------------
           player1Hand = player1.throwDice(player1.getDiceCount());
           System.out.println("\n\nPlayer 1 roll: "+player1Hand);

           p1sumBet = player1.sumBet(player1Hand);
           System.out.println("\nYour dice totals: "+p1sumBet);
           System.out.println("Face #             1  2  3  4  5  6");
           player2Hand = player2.throwDice(player2.getDiceCount());
           //System.out.println(player2Hand);

           p2sumBet = player2.sumBet(player2Hand);
           //System.out.println(p2sumBet+"\n\n");

           totalBet = player1.sumDiceCups(p1sumBet,p2sumBet);
           //System.out.println("Total bet in play "+totalBet);  //for testing

           //Place Bets
           System.out.print("\nPlace your bet. Quantity of the dice first: ");
           Scanner input = new Scanner(System.in);
           int betQty = input.nextInt();
           System.out.print("Now bet on the face: ");
           int faceValue = input.nextInt();

            if (betCompare(betQty, faceValue, totalBet)){
                System.out.println("\nExcellent bet!");
                player1.dicePlus(1);
                player2.diceMinus(1);
            }
                else{
                System.out.println("\nBad guess, lose a die to Player 2");
                    player2.dicePlus(1);
                    player1.diceMinus(1);
            }

           System.out.println("\nPlayer 1 dice count: "+player1.getDiceCount());
           System.out.println(  "Player 2 dice count: "+player2.getDiceCount());

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

    public static boolean betCompare(int quantity, int face, ArrayList totalBet) {
        Object[] totalBetArray = totalBet.toArray();
        for (int i = face; i <= face; i++){
            //validate inputs first
            if ((face < 1) || (face > 6) || (quantity < 0)) {

                System.out.println("Invalid bet, try again");
                Scanner input = new Scanner(System.in);
                System.out.print("Please bet a face: ");
                face = input.nextInt();

                System.out.print("Please bet an amount: ");
                quantity = input.nextInt();
                betCompare(quantity, face, totalBet);
                break;
            }
            if (quantity == (int)totalBetArray[face-1]) {
                return true;
            }
        }
        return false;
    }
}