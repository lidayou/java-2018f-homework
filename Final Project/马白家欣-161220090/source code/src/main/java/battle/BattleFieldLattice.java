package battle;

import being.*;

/**
 * @Description 战场方格，每个方格都含有一个CartoonCharacter角色，注意什么都没有也是一种特殊的CartoonCharacter
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */
public class BattleFieldLattice {

    private Being being;

    public BattleFieldLattice() {
        this.being = new CartoonCharacter();
    }

    public BattleFieldLattice(Being being) {
        assert being != null;
        this.being = being;
    }

    public Being getBeing() {
        return being;
    }
}
