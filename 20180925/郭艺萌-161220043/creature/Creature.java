package creature;

import map.*;

public class Creature {

	//移动到指定位置 即在该位置上放置该生物
	public void move(Position pos) {
		pos.setCreature(this);
	}
}
