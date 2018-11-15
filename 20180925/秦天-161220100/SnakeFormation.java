//package qt;

public class SnakeFormation implements Formation {

	@Override
	public void format(BattleField battleField, Troop troop, boolean left) {
		battleField.reset(left);
		Fighter[] fighters=troop.getFighters();
		Audience audience=troop.getAudience();
		int numSoldier=fighters.length;
		int x=battleField.getM()/2-numSoldier/2,y=battleField.getN()/4;
		if(!left)
			y*=3;
		for(int i=0;i<numSoldier;i++) {
			fighters[i].setPosition(x, y);
			battleField.set(fighters[i], new Position(x,y));
			x++;
		}
		Position audPos=battleField.getEmptyPosition(left);
		audience.setPosition(audPos);
		battleField.set(audience, audPos);
	}
	
}
