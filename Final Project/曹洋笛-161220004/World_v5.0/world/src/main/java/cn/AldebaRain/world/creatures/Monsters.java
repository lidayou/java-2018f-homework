package cn.AldebaRain.world.creatures;

import cn.AldebaRain.world.util.CreatureType;

/**
 *	小喽啰 
 *
 *	@author AldebaRain
 */
public class Monsters extends Creature {
	
	public Monsters() {
		super();
		type = CreatureType.Mons;
		name = "小喽啰";
		symbol = 'o';
	}
}
