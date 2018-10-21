package com.homework3;

//阵型
public enum Formation {
    HE_YI(3, 0, 3, 4), YAN_XING(2, 2, 2, 3), HENG_E(2, 3, 1, 2), CHANG_SHE(0, 6, 2, 0), YU_LIN(0, 4, 3, 4),
    FANG_YUAN(2, 2, 4, 0), YAN_YUE(4, 4, 4, 4), FENG_SHI(0, 5, 3, 4);

    private int upOffset;
    private int downOffset;
    private int leftOffset;
    private int rightOffset;

    Formation(int upOffset, int downOffset, int leftOffset, int rightOffset) {
        this.upOffset = upOffset;
        this.downOffset = downOffset;
        this.leftOffset = leftOffset;
        this.rightOffset = rightOffset;
    }

    public int getUpOffset() {
        return upOffset;
    }

    public int getDownOffset() {
        return downOffset;
    }

    public int getLeftOffset() {
        return leftOffset;
    }

    public int getRightOffset() {
        return rightOffset;
    }

    public static void initFormation(BattleField battleField) {
        battleField.clearBattleField();

        Position justicePosition = new Position(BattleField.FIELD_SIZE / 2, BattleField.FIELD_SIZE / 3);
        Position evilPosition = new Position(BattleField.FIELD_SIZE / 2, 2 * BattleField.FIELD_SIZE / 3);
        draw(Formation.CHANG_SHE, battleField, justicePosition);
        draw(Formation.HE_YI, battleField, evilPosition);
    }

    public static void changeFormation(Formation evilFormation, Position evilPosition,
                                       Position justicePosition, BattleField battleField) {

//        assert ((formation == CHANG_SHE && camp == CartoonCharacterCamp.JUSTICE) ||
//                (formation != CHANG_SHE && camp == CartoonCharacterCamp.EVIL)) : "ERROR in Formation";

        battleField.clearBattleField();

        draw(evilFormation, battleField, evilPosition);
        draw(CHANG_SHE, battleField, justicePosition);
    }

    private static void draw(Formation formation, BattleField battleField, Position position) {
        if (formation == HE_YI) {
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.SCORPION);
            position.move(-1, 1);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(-1, 1);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(-1, 1);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(2, -4);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(-1, -1);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(-1, -1);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(3, 7);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.SNAKE);
        } else if (formation == CHANG_SHE) {
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.RED);
            position.move(1, 0);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.ORANGE);
            position.move(1, 0);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.YELLOW);
            position.move(1, 0);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.GREEN);
            position.move(1, 0);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.CYAN);
            position.move(1, 0);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.BLUE);
            position.move(1, 0);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.PURPLE);
            position.move(-3, -2);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.GRANDFATHER);
        } else if (formation == YAN_XING) {
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.SCORPION);
            position.move(0, 3);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.SNAKE);
            position.move(-1, -2);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(-1, 1);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(3, -3);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(1, -1);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
        } else if (formation == HENG_E) {
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.SCORPION);
            position.move(0, 2);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.SNAKE);
            position.move(-1, -3);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(-1, 1);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(3, -1);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(1, 1);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(1, -1);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
        } else if (formation == YU_LIN) {
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.SCORPION);
            position.move(0, 4);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.SNAKE);
            position.move(1, -3);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(1, -3);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(0, 2);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(0, 2);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(1, -5);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(0, 2);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(0, 2);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(0, 2);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(1, -3);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
        } else if (formation == FANG_YUAN) {
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.SCORPION);
            position.move(0, -2);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.SNAKE);
            position.move(-1, 1);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(-1, -1);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(1, -1);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(1, -1);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(1, 1);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(1, 1);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(-1, 1);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
        } else if (formation == YAN_YUE) {
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.SCORPION);
            position.move(0, 4);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.SNAKE);
            position.move(0, -6);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(0, -2);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(-1, 0);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(0, 2);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(0, 2);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(2, 0);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(0, -2);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(0, -2);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(-3, 3);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(0, 2);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(-1, -1);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(0, 2);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(-1, 1);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(8, 0);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(-1, -1);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(0, -2);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(-1, 1);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(0, -2);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
        } else if (formation == FENG_SHI) {
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.SCORPION);
            position.move(0, 4);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.SNAKE);
            position.move(1, -5);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(0, 1);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(0, 1);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(1, -1);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(0, -2);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(0, 4);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(1, -2);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(0, -3);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(0, 6);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(0, -3);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(1, 0);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
            position.move(1, 0);
            battleField.setBattleFieldLattice(position, CartoonCharacterInfo.LOW_LEVEL_DEMON);
        } else {
            assert false : "[ERROR] in draw()";
        }
    }
}
