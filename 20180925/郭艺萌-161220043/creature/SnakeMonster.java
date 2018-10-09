package creature;

import map.Map;

public class SnakeMonster extends Creature implements Cheer{
	private String name = "蛇精";
	
	public String getName() {
		return name;
	}
	
	@Override 
	public void cheer(Map map, int x, int y) {
		move(map.getPos()[x][y]);
	}
}
