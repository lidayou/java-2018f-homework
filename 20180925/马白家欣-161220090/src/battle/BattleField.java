package com.homework3.battle;

import com.homework3.being.*;
import com.homework3.position.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description 战场，包含了战场方格二维数组battleFieldLatticeArray，主要职责是操纵battleFieldLatticeArray
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */

public class BattleField <T extends CartoonCharacter> {
    public static final int FIELD_SIZE = 15;
    public static final int ICON_SIZE = 40;
    public static final int BORDER_THICKNESS = 1;

    private List<BattleFieldLattice> battleFieldLatticeArray = new ArrayList<>();

    public BattleField() {
        for (int i = 0; i < FIELD_SIZE * FIELD_SIZE; i++) {
            battleFieldLatticeArray.add(new BattleFieldLattice());
        }
    }

    public void setBattleFieldLattice(Map<Position, T> map, Position startPosition) {
        for (int i = -FIELD_SIZE; i < FIELD_SIZE; i++) {
            for (int j = -FIELD_SIZE; j < FIELD_SIZE; j++) {
//                CartoonCharacter cartoonCharacter = map.get(new Position(i, j));
//                if (cartoonCharacter != null) {
//                    assert i + startPosition.getRow() < FIELD_SIZE && j + startPosition.getCol() < FIELD_SIZE;
//                    this.battleFieldLatticeArray.set((i + startPosition.getRow()) * FIELD_SIZE + (j + startPosition.getCol())
//                            , new BattleFieldLattice(cartoonCharacter));
//                }
                if(map.containsKey(new Position(i, j)))
                {
                    CartoonCharacter cartoonCharacter = map.get(new Position(i, j));
                    assert i + startPosition.getRow() < FIELD_SIZE && j + startPosition.getCol() < FIELD_SIZE;
                    this.battleFieldLatticeArray.set((i + startPosition.getRow()) * FIELD_SIZE + (j + startPosition.getCol())
                            , new BattleFieldLattice(cartoonCharacter));
                }
            }
        }
    }

    public BattleFieldLattice getBattleFieldLattice(int i, int j) {

        return this.battleFieldLatticeArray.get(i * FIELD_SIZE + j);
    }

    public void clearBattleField() {

        for (int i = 0; i < FIELD_SIZE * FIELD_SIZE; i++) {
            battleFieldLatticeArray.set(i, new BattleFieldLattice());
        }
    }
}
