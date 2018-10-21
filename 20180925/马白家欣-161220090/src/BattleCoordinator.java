package com.homework3;

import java.util.Random;

public class BattleCoordinator {

    static final int MAX_LOOP_COUNT = 10;
    static final boolean DEBUG = false;

    public static void main(String[] args) {
        if(DEBUG == false)
        {
            BattleGoOn();
        }
        else
        {
            printAllFormation();
        }
    }

    private static justiceAndEvilPosition createRandomPosition(Formation evilFormation, Formation justiceFormation) {
        Random rand = new Random();
        int evilUpOffset = evilFormation.getUpOffset();
        int evilDownOffset = evilFormation.getDownOffset();
        int evilLeftOffset = evilFormation.getLeftOffset();
        int evilRightOffset = evilFormation.getRightOffset();

        int justiceUpOffset = justiceFormation.getUpOffset();
        int justiceDownOffset = justiceFormation.getDownOffset();
        int justiceLeftOffset = justiceFormation.getLeftOffset();
        int justiceRightOffset = justiceFormation.getRightOffset();

        justiceAndEvilPosition newPosition = new justiceAndEvilPosition();

        do {
            newPosition.evilPosition = new Position(
                    rand.nextInt(BattleField.FIELD_SIZE - (evilUpOffset + evilDownOffset)) + evilUpOffset,
                    rand.nextInt(BattleField.FIELD_SIZE - (evilLeftOffset + evilRightOffset)) + evilLeftOffset);

            newPosition.justicePosition = new Position(
                    rand.nextInt(BattleField.FIELD_SIZE - (justiceUpOffset + justiceDownOffset)) + justiceUpOffset,
                    rand.nextInt(BattleField.FIELD_SIZE - (justiceLeftOffset + justiceRightOffset)) + justiceLeftOffset);
        }
        while ((Math.max(newPosition.justicePosition.getRow() - justiceUpOffset, newPosition.evilPosition.getRow() - evilUpOffset)
                <= Math.min(newPosition.justicePosition.getRow() + justiceDownOffset, newPosition.evilPosition.getRow() + evilDownOffset))
                && (Math.max(newPosition.justicePosition.getCol() - justiceLeftOffset, newPosition.evilPosition.getCol() - evilLeftOffset)
                <= Math.min(newPosition.justicePosition.getCol() + justiceRightOffset, newPosition.evilPosition.getCol() + evilRightOffset)));

        return newPosition;
    }

    //just for debug
    public static void printAllFormation() {
        BattleField battleField = new BattleField();
        for (int i = 0; i < Formation.values().length; i++) {
            justiceAndEvilPosition newPosition = createRandomPosition(Formation.values()[i], Formation.CHANG_SHE);
            Formation.changeFormation(Formation.values()[i],
                    newPosition.evilPosition, newPosition.justicePosition, battleField);
            battleField.printBattleField();
        }
    }

    public static void BattleGoOn() {
        Random rand = new Random();
        BattleField battleField = new BattleField();
        Formation.initFormation(battleField);
        battleField.printBattleField();
        for (int i = 0; i < MAX_LOOP_COUNT; i++) {
            int formationNumber;
            do {
                formationNumber = rand.nextInt(Formation.values().length);
            } while (Formation.values()[formationNumber] == Formation.CHANG_SHE);
            justiceAndEvilPosition newPosition = createRandomPosition(Formation.values()[formationNumber],
                    Formation.CHANG_SHE);
            Formation.changeFormation(Formation.values()[formationNumber],
                    newPosition.evilPosition, newPosition.justicePosition, battleField);
            battleField.printBattleField();
        }
    }
}

class justiceAndEvilPosition {
    public Position justicePosition;
    public Position evilPosition;
}
