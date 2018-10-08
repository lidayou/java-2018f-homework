package formation;

import creature.*;
import map.*;

public interface Formation {
	//地图，要排队的生物，队首的位置信息
	public void form(Map map, Creature[] creatures, int x, int y);
	public void loose(Map map, Creature[] creatures, int x, int y);
}
