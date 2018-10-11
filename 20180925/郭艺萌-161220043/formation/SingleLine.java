package formation;

import creature.*;
import map.*;

public class SingleLine implements Formation{
	@Override
	public void form(Map map, Creature[] creatures, int x, int y) {
		for (int i = 0; i < creatures.length; i++) {
			if (map.canStand(x+i, y))
				creatures[i].move(map.getPos()[x+i][y]);
		}
	}
	@Override
	public void loose(Map map, Creature[] creatures, int x, int y) {
		for (int i = 0; i < creatures.length; i++) {
			if (map.canRemove(x+i, y))
				map.getPos()[x+i][y].removeCrearure();
		}
	}
}

