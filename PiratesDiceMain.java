import java.util.ArrayList;

public class PiratesDiceMain {
    public static void main(String[] args) {

        int diceCount = 5;
        int playerCount = 3;

        DiceCup player1 = new DiceCup(diceCount);
        DiceCup player2 = new DiceCup(diceCount);

        //player#Hand is the dice throw result
        ArrayList <Integer> player1Hand;
        ArrayList <Integer> player2Hand;

        //player#sumBet shows qty of 1,2,3,4,5,6's thrown per cup
        ArrayList <Integer> p1sumBet;
        ArrayList <Integer> p2sumBet;

        //***********************Introduction and Rules*******************************//
//        System.out.println("\n\n******Arrr, this be Liar's Dice******");
//        System.out.println("\n\nEach player will receive 5 dice");
//        System.out.println("All dice will be thrown under your cups");
//
//        System.out.println("\nBids are made against all dice in play, on the");
//        System.out.println("quantity of dice of a face value. Bids must increase");
//        System.out.println("in quantity of a face, or increase the face value itself.");
//        System.out.println("You may only decrease quantity with an increase of face value.");
//        System.out.println("If you choose to increase both, you can only continue bidding upwards");
//
//        System.out.println("\nYou may instead challenge the previous bid instead of bidding.");
//        System.out.println("When a challenge is issued, all players will reveal their dice.");
//        System.out.println("If the previous bid was a LIE, you win one of that player's dice.");
//        System.out.println("If you guessed wrong, the challenged gets one of YOUR dice.");
//        System.out.println("\n\nLast one with dice wins.\n\n");
//
//        System.out.println("Player 1 is you, Player 2 is the computer. ");


        //Main gameplay loop
       while (playerCount > 1){

           //throw dice
           player1Hand = player1.throwDice(player1.getDiceCount());
           System.out.println(player1Hand);

           p1sumBet = player1.sumBet(player1Hand);
           System.out.println(p1sumBet+"\n\n");

           player2Hand = player2.throwDice(player2.getDiceCount());
           System.out.println(player2Hand);

           p2sumBet = player2.sumBet(player2Hand);
           System.out.println(p2sumBet+"\n\n");

           System.out.println(player1.sumDiceCups(p1sumBet,p2sumBet));





           playerCount--;
       }

//   System.out.println("You may bid a higher quantity of face "+FaceValue+
//                      " or some amount of a higher face than"+FaceValue+", or both. ");
    }
}
