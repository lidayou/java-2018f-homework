package creature;

import map.Map;

public class ScorpionMonster extends Creature{
	private String name = "蝎子精";
	
	public String getName() {
		return name;
	}
	
	public void lead(Map map, int x, int y) {
		move(map.getPos()[x][y]);
	}
}
