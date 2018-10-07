package creature;

import map.Map;

public class GrandFather extends Creature implements Cheer{
	private String name = "үү";
	
	public String getName() {
		return name;
	}
	@Override
	public void cheer(Map map, int x, int y) {
		move(map.getPos()[x][y]);
	}
}
