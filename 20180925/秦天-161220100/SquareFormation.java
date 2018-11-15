//package qt;

public class SquareFormation implements Formation{
	@Override
	public void format(BattleField battleField, Troop troop, boolean left) {
		battleField.reset(left);
		Fighter[] fighters=troop.getFighters();
		Audience audience=troop.getAudience();
		int numSoldier=fighters.length;
		int x=battleField.getM()/2;
		int y=left?battleField.getN()/2-1:battleField.getN()/2+1;
		fighters[0].setPosition(x, y);
		battleField.set(fighters[0], new Position(x,y));
		y=left?y-1:y+1;
		int cnt=1;
		int cols=(numSoldier-1)/2,gap=0;
		for(int i=0;i<=(cols-1)/2;i++) {
			gap=i+1;
			fighters[cnt].setPosition(x-gap, y);
			battleField.set(fighters[cnt++], new Position(x-gap,y));
			fighters[cnt].setPosition(x+gap, y);
			battleField.set(fighters[cnt++], new Position(x+gap,y));
			y=left?y-1:y+1;
		}
		gap=(cols%2==0)?gap:gap-1;
		for(int i=(cols-1)/2+1;i<cols;i++) {
			fighters[cnt].setPosition(x-gap, y);
			battleField.set(fighters[cnt++], new Position(x-gap,y));
			fighters[cnt].setPosition(x+gap, y);
			battleField.set(fighters[cnt++], new Position(x+gap,y));
			y=left?y-1:y+1;
			gap--;
		}
		if(cnt<numSoldier) {
			fighters[cnt].setPosition(x, y);
			battleField.set(fighters[cnt++], new Position(x,y));
		}
		Position audPos=battleField.getEmptyPosition(left);
		audience.setPosition(audPos);
		battleField.set(audience, audPos);
	}
}
