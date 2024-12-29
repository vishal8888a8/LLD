package SnakeAndLadder.Dice;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int countOfDice;

    public Dice(int countOfDice) {
        this.countOfDice = countOfDice;
    }

    public int rollTheDice() {
        int roll = 0;
        int countOfRoll = 0;
        while ( countOfRoll < countOfDice ) {
            roll += resultOfSingleDiceRoll();
            countOfRoll++;
        }
        return roll;
    }

    private int resultOfSingleDiceRoll() {
        return ThreadLocalRandom.current().nextInt(1,7);
    }
}
