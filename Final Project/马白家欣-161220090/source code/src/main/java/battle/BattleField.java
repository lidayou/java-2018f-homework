package battle;

import gui.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description
 * @Author LUCUS BAI
 * @Date 2018/12/12
 */
public class BattleField {

    public static List<BattleFieldLattice> getEmptyBattleFieldLatticeList() {
//        List<BattleFieldLattice> battleFieldLatticeList = new ArrayList<>();
        List<BattleFieldLattice> battleFieldLatticeList = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < Controller.FIELD_WIDTH * Controller.FIELD_HEIGHT; i++) {
            battleFieldLatticeList.add(new BattleFieldLattice());
        }
        return battleFieldLatticeList;
    }
}
