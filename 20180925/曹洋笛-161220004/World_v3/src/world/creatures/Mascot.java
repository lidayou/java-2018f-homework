package world.creatures;

/**
 *	À²À²¶Ó³éÏóÀà
 *	
 *	@author Mirror
 */
public abstract class Mascot extends Creature {

	protected Mascot() {
		super();
	}
	
	public void cheers() {
		System.out.println(name + ": Come on !");
	}
}
