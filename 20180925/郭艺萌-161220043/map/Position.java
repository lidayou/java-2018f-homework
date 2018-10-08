package map;

import creature.*;

public class Position {

	private int x, y;
	private boolean isSet; 
	private Creature creature;
	
	public Position(int x, int y) {
		this.x = x;
		this.y =y;
		this.isSet = false;
		this.creature = null; //?
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public boolean getIsSet() {
		return isSet;
	}
	public Creature getCreature() {
		if (isSet) {
			return this.creature;
		} else {
		//	System.out.println("米有东西");
			return null;
		}
	}
	
	public void setCreature(Creature creature) {
		if (isSet) {
		//	System.out.println("~~移走啦");
		}
		isSet = true;
		this.creature = creature;
	}
	public void removeCrearure() {
		isSet = false;
		this.creature = null; //?
	}
}
