package com.homework3;

public class BattleField {
    public static final int FIELD_SIZE = 15;
    private BattleFieldLattice battleFieldLatticeArray[][] = new BattleFieldLattice[FIELD_SIZE][];

    public BattleField() {
        for (int i = 0;i < FIELD_SIZE; i++) {
            battleFieldLatticeArray[i] = new BattleFieldLattice[FIELD_SIZE];
        }

        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                Position tempPosition = new Position(i, j);
                battleFieldLatticeArray[i][j] = new BattleFieldLattice(tempPosition);
            }
        }
    }

    public void setBattleFieldLattice(Position position, CartoonCharacterInfo cartoonCharacterInfo) {
        int row = position.getRow();
        int col = position.getCol();
        if (row >= 0 && row <= FIELD_SIZE - 1 && col >= 0 && col <= FIELD_SIZE - 1) {
            this.battleFieldLatticeArray[row][col] = new BattleFieldLattice(position, cartoonCharacterInfo);
        }
    }

    public void clearBattleField() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                Position tempPosition = new Position(i, j);
                battleFieldLatticeArray[i][j] = new BattleFieldLattice(tempPosition);
            }
        }
    }

    public void printBattleField() {
        for(int k = 0;k<FIELD_SIZE + 2;k++){
            System.out.print("-");
        }
        System.out.println();
        for(int i = 0;i<FIELD_SIZE;i++)
        {
            System.out.print("|");
            for(int j =0;j<FIELD_SIZE;j++)
            {
                System.out.printf("%s", battleFieldLatticeArray[i][j].getCartoonCharacter());
            }
            System.out.print("|");
            System.out.println();
        }
        for(int k = 0;k<FIELD_SIZE + 2;k++){
            System.out.print("-");
        }
        System.out.println();
    }

}

