package Update2.Creature;

import Update2.BattleField;
import Update2.Creature.Creature;
import Update2.Strategy.Changshe;
import Update2.Strategy.Heyi;
import Update2.Strategy.Strategy;
import Update2.Strategy.Yuling;
import Update2.UI;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
enum MONSTERS {
    UGLY("小喽啰"), BOSS("大蛇精");
    private String name;

    private MONSTERS(String a) {
        this.name = a;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String a) {
        this.name = a;
    }
}

public class Evil extends Creature implements ItemListener{
    private MONSTERS man;
    final int row = 15;
    final int col = 10;
    final int base_col = 10;
    private UI bat;
    public Evil(UI b) {
        man = MONSTERS.BOSS;
        bat = b;
    }

    public Evil(MONSTERS p) {
        switch (p) {
            case UGLY:
                man = MONSTERS.UGLY;
                break;
            case BOSS:
                man = MONSTERS.BOSS;
                break;
        }
    }

    @Override
    public void Show() {
        System.out.print(man.getName());
    }

    public String Identity(){return man.getName();};

    public void UseStrategy(Strategy str) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (str.Arrange(i, j)) {
                    bat.SetCreature(i, base_col + j, new Evil(MONSTERS.UGLY));
                } else
                    bat.SetCreature(i, base_col + j, new Creature());
            }
        }
        //给BOSS安排位置
        int x_pos = str.CoreX(false);
        int y_pos = str.CoreY(false);
        bat.SetCreature(x_pos,y_pos+base_col, new Evil(MONSTERS.BOSS));
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {     // 查看是否为新选中的选项触发
            if (e.getItem().equals("长蛇阵")) {  // 查看触发的选项
                System.out.println("Demon 长蛇阵");
                UseStrategy(new Changshe());
            }
            else if(e.getItem().equals("鹤翼阵")){
                System.out.println("Demon 鹤翼阵");
                UseStrategy(new Heyi());
            }
            else if(e.getItem().equals("鱼鳞阵")){
                System.out.println("Demon 鱼鳞阵");
                UseStrategy(new Yuling());
            }
            else {
                ;
            }
        }
    }
}
