import java.util.ArrayList;

public class DiceCup {

    private int diceCount;

    private ArrayList<Integer> diceRolls = new ArrayList<>();
    private ArrayList<Integer> cupDiceTotal = new ArrayList<>();
    private ArrayList<Integer> allDiceCupsTotal= new ArrayList<>();

    private boolean firstThrow = true;
    private boolean boolGainedDie = false;
    private boolean boolLostDie = false;


    public DiceCup(int diceCount){
        this.diceCount = diceCount;

        for (int i = 0; i < 6; i++){
            cupDiceTotal.add(i,0);
        }
        for (int i = 0; i < 6; i++){
            allDiceCupsTotal.add(i,0);
        }
    }


    public ArrayList<Integer> throwDice(int diceCount){
        ArrayList<Integer> diceRolls1 = this.diceRolls;

        if (firstThrow) {
            for (int i = 0; i < diceCount; i++) {
                diceRolls1.add(i, 0);  //first throw, populate with values
            }
            firstThrow = false;
        }
        if (boolLostDie){
            diceRolls1.remove(String.valueOf(diceRolls1.size()).length());
        }
        if (boolGainedDie){
            diceRolls1.add(0);
        }
        for (int i = 0; i < diceCount; i++){
            double temp = Math.random();
            temp = (temp * 6) + 1;
            int dieValue = (int)(temp);
            diceRolls1.set(i, dieValue);
        }

        boolLostDie = false;
        boolGainedDie = false;
        return diceRolls1;
    }


    public ArrayList<Integer> getDiceRolls(){
        return diceRolls;
    }

    public int getDiceCount(){
        return diceCount;
    }

    public void setDiceCount(int newDiceCount){
        diceCount = newDiceCount;
    }

    public ArrayList<Integer> sumBet(ArrayList diceRolls){
        for (int i = 0; i < diceRolls.size(); i++){
            for (int j = 1; j <= 6; j++){
                int dieValue = (int)(diceRolls.get(i));
                if (dieValue == j){
                    //get item, set to temp, add, set back in array
                    int temp = cupDiceTotal.get(j-1);
                    temp += 1;
                    cupDiceTotal.set(j-1, temp);
                }
            }
        }
        return cupDiceTotal;
    }

    public ArrayList<Integer> sumDiceCups(ArrayList p1sumBet, ArrayList p2sumBet){
        for (int i = 0; i < 6; i++){
            int x = (int)(p1sumBet.get(i));
            for (int j = i; j <= i; j++){
                int y = (int)(p2sumBet.get(j));
                int sum = x + y;
                allDiceCupsTotal.set(i,sum);
            }
        }
        return allDiceCupsTotal;
    }
    public boolean diceMinus(int diceLost){
        int temp = getDiceCount();
        temp = temp - diceLost;
        setDiceCount(temp);
        System.out.println("Current Dice Count: "+getDiceCount());
        return boolLostDie = true;
    }
    public boolean dicePlus(int additionalDice){
        int temp = diceCount;
        temp = temp + additionalDice;
        setDiceCount(temp);
        System.out.println("Current Dice Count: "+getDiceCount());
        return boolGainedDie = true;

    }
}