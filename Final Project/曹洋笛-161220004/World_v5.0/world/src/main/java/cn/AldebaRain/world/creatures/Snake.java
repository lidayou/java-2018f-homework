package cn.AldebaRain.world.creatures;

import cn.AldebaRain.world.util.CreatureType;

/**
 *	从啦啦队转入战队的蛇精
 *	
 *	@author AldebaRain
 */
public final class Snake extends Creature {

	public Snake() {
		super();
		type = CreatureType.Snk;
		name = "蛇精";
		symbol = 'S';
	}
}
