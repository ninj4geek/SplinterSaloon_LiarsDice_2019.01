class Text {

    Text() {
    }

    static void introductionText () {
        //***********************Introduction and Rules*******************************//
        System.out.println("\n\n******Arr, this be Liar's Dice******");
        System.out.println("\n\nEach player will receive 5 dice");
        System.out.println("All dice will be thrown under your cups");

        System.out.println("\nBids are made against all dice in play, on the");
        System.out.println("quantity of dice of a face value.");
        System.out.println("If you bid correctly, you win a die from the computer.");
        System.out.println("If you guessed wrong, the computer gets one of YOUR dice.");
        System.out.println("\nLast one with dice wins.");

        System.out.println("\nPlayer 1 is you, Player 2 is the computer. ");
    }


    static void showDiceCount(Player player1, Player player2){
        System.out.println("\nPlayer 1 dice count: " + player1.getDiceCount());
        System.out.println("Player 2 dice count: " + player2.getDiceCount());
    }
}
