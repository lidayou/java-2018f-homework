package com.homework3.battle;

import com.homework3.being.*;
import com.homework3.common.*;
import com.homework3.factory.EvilFactory;
import com.homework3.formation.*;
import com.homework3.output.*;
import com.homework3.position.*;

import java.util.List;

/**
 * @Description 万物始祖，一切战斗情节的控制器
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */
public class BattleCoordinator {

    static final int MAX_LOOP_COUNT = 1;

    public static void main(String[] args) {
        BattleGoOn();
    }

    public static void BattleGoOn() {

        BattleField<CartoonCharacter> battleField = new BattleField<>();
        BattleFieldDisplay battleFieldDisplay = new BattleFieldDisplay();
        for (int i = 0; i < MAX_LOOP_COUNT; i++) {
            List<Formation> evilFormation = CreateRandomFormationArray.createRandomFormationArray(new EvilFactory());
            for (int j = 0; j < evilFormation.size(); j++) {
                Formation justiceFormation = new ChangShe<>(new Justice());
                JusticeAndEvilPosition newPosition = CreateRandomPosition.createRandomPosition(evilFormation.get(j), justiceFormation);
                evilFormation.get(j).changeFormation(newPosition.evilPosition, battleField);
                justiceFormation.changeFormation(newPosition.justicePosition, battleField);
                battleFieldDisplay.display(battleField);
                battleField.clearBattleField();
            }
        }
    }
}
