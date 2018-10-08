package formation;

import creature.*;
import map.*;

//£¨1,17£©
public class EnEchelon implements Formation{
	@Override
	public void form(Map map, Creature[] creatures, int x, int y) {
		for (int i = 0; i < 5; i++) {	
			if (map.canStand(x+i, y-i)) {
				creatures[i].move(map.getPos()[x+i][y-i]);				
			}
		}
	}
	@Override
	public void loose(Map map, Creature[] creatures, int x, int y) {
		for (int i = 0; i < 5; i++) {
			if (map.canRemove(x+i, y-i)) {
				map.getPos()[x+i][y-i].removeCrearure();	
			}
		}
	}
}

