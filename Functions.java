import java.util.List;
import java.util.Scanner;

class Functions {
    private final static Scanner input = new Scanner(System.in);

    Functions() {
    }

    static int retrieveBetQuantity(){
        System.out.print("\nPlace your bet. \nQuantity of the dice first: ");
        return input.nextInt();
    }

    static int retrieveBetFaceValue(){
        System.out.print("Now bet on the face: ");
        return input.nextInt();
    }

    static List playRound(Player player1, Player player2){

        List <Integer> player1DiceThrow;
        List <Integer> player2DiceThrow;

        List <Integer> p1QtyDicePerFace;
        List <Integer> p2QtyDicePerFace;
        List <Integer> totalQtyOfDicePerFace;

        player1DiceThrow = player1.throwDice(player1.getDiceCount());
        System.out.println("\n\nPlayer 1 roll: "+player1DiceThrow);

        p1QtyDicePerFace = player1.sumDiceFaces(player1DiceThrow);
        System.out.println("\nYour dice totals: "+p1QtyDicePerFace);
        System.out.println("Face #             1  2  3  4  5  6");

        player2DiceThrow = player2.throwDice(player2.getDiceCount());
        //System.out.println(player2DiceThrow);

        p2QtyDicePerFace = player2.sumDiceFaces(player2DiceThrow);
        //System.out.println(p2QtyDicePerFace+"\n\n");

        totalQtyOfDicePerFace = player1.sumDiceCups(p1QtyDicePerFace,p2QtyDicePerFace);

        return totalQtyOfDicePerFace;
    }

    static boolean betCompare(int quantity, int face, List totalBet) {
        Object[] totalBetArray = totalBet.toArray();
        for (int i = face; i <= face; i++){
            //validate inputs first
            if ((face < 1) || (face > 6) || (quantity < 0)) {

                System.out.println("Invalid bet, try again");
                face = Functions.retrieveBetFaceValue();
                quantity = Functions.retrieveBetQuantity();
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
