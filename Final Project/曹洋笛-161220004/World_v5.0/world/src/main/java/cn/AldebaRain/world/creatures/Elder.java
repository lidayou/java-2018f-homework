package cn.AldebaRain.world.creatures;

import cn.AldebaRain.world.util.CreatureType;

/**
 *	从啦啦队转入战队的老爷爷
 *	
 *	@author AldebaRain
 */
public final class Elder extends Creature {

	public Elder() {
		super();
		type = CreatureType.Eld;
		name = "老爷爷";
		symbol = 'Y';
	}
}
