import creature.Bad;
import creature.CalabashBrother;
import formation.*;
import space.CalabashWorld;

public class Stalemate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//初始化
		CalabashWorld world = new CalabashWorld();
		//葫芦娃乱序
		world.brothersShuffle();
	
		//葫芦娃排序，长蛇阵，投放
		world.brothersSort();
		world.setBrothers(new Changshe<CalabashBrother>(), 4, 1);
		
		//蝎子精、小喽啰选择阵型，投放
		world.setMonsters(new Heyi<Bad>(), 3, 8);
		
		//老爷爷、蛇精投放，加油
		world.setCheerleaders();
		//输出
		world.displayField();
		
		world.clearBattleField();
		
		world.setBrothers(new Changshe<CalabashBrother>(), 4, 2);
		world.setMonsters(new Henge<Bad>(), 3, 13);
		world.setCheerleaders();
		world.displayField();
		
		world.clearBattleField(); 
		
		world.setBrothers(new Changshe<CalabashBrother>(), 4, 2);
		world.setMonsters(new Yanxing<Bad>(), 3, 6);
		world.setCheerleaders();
		world.displayField();
	}

}