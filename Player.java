import java.util.ArrayList;
import java.util.List;

class Player {

    private int diceCount;

    private List<Integer> diceRolls = new ArrayList<>();
    private List<Integer> playerDiceFacesTotal = new ArrayList<>();
    private List<Integer> allPlayerDiceFacesTotal = new ArrayList<>();

    private boolean firstThrow;
    private boolean boolGainedDie1;
    private boolean boolLostDie1;

    Player(int diceCount) {
        this.firstThrow = true;
        this.boolGainedDie1 = false;
        this.boolLostDie1 = false;
        this.diceCount = diceCount;

        for (int i = 0; i < 6; i++) {
            playerDiceFacesTotal.add(i, 0);
        }

        for (int i = 0; i < 6; i++) {
            allPlayerDiceFacesTotal.add(i, 0);
        }
    }

    List<Integer> throwDice(int diceCount) {
        List<Integer> diceRolls1 = this.diceRolls;

        if (firstThrow) {
            for (int i = 0; i < diceCount; i++) {
                diceRolls1.add(i, 0);  //first throw, populate with values
            }
            firstThrow = false;
        }
        if (boolLostDie1) {
            diceRolls1.remove(String.valueOf(diceRolls1.size()).length());
        }
        if (boolGainedDie1) {
            diceRolls1.add(0);
        }
        for (int i = 0; i < diceCount; i++) {
            double temp = Math.random();
            temp = (temp * 6) + 1;
            int dieValue = (int) (temp);
            diceRolls1.set(i, dieValue);
        }

        boolLostDie1 = false;
        boolGainedDie1 = false;
        return diceRolls1;
    }

    List<Integer> sumDiceFaces(List diceRolls) {
        resetList(playerDiceFacesTotal);
        for (int i = 0; i < diceRolls.size(); i++) {
            for (int j = 1; j <= 6; j++) {
                int dieValue = (int) (diceRolls.get(i));
                if (dieValue == j) {
                    //get item, set to temp, add, set back in list
                    int temp = playerDiceFacesTotal.get(j - 1);
                    temp += 1;
                    playerDiceFacesTotal.set(j - 1, temp);
                }
            }
        }
        return playerDiceFacesTotal;
    }
    List<Integer> sumDiceCups(List p1sumBet, List p2sumBet) {
        for (int i = 0; i < 6; i++) {
            int p1DiceSum = (int) (p1sumBet.get(i));
            for (int j = i; j <= i; j++) {
                int p2DiceSum = (int) (p2sumBet.get(j));
                int sum = p1DiceSum + p2DiceSum;
                allPlayerDiceFacesTotal.set(i, sum);
            }
        }
        return allPlayerDiceFacesTotal;
    }

    boolean loseADie() {
        int temp = getDiceCount();
        temp = temp - 1;
        setDiceCount(temp);
        return boolLostDie1 = true;
    }

    boolean gainADie() {
        int temp = diceCount;
        temp = temp + 1;
        setDiceCount(temp);
        return boolGainedDie1 = true;
    }

    private void resetList(List list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, 0);
        }
    }
    int getDiceCount() {
        return diceCount;
    }

    private void setDiceCount(int newDiceCount) {
        diceCount = newDiceCount;
    }
}