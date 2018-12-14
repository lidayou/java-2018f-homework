package calabash;

public class Formation {
	int number;
	Field area = new Field();
	
	Formation(Field area){
		this.area = area;
	}
	
	public void longSnakeFormation() {
		for(int i = 4; i < 11; i++) {
			Calabash bro = new Calabash(i-4, i, 3);
			area.updateField(bro.getX(), bro.getY(), bro.getName());
		}
		Grandfather grand = new Grandfather(4, 1);
		area.updateField(grand.getX(), grand.getY(), grand.getName() + ":" + grand.cheerGrand());
	}
	
	public void yokeFormation() {
		area.clearMonster();
		LittleBrother lit1 = new LittleBrother(4, 12);
		LittleBrother lit2 = new LittleBrother(5, 11);
		LittleBrother lit3 = new LittleBrother(6, 12);
		LittleBrother lit4 = new LittleBrother(7, 12);
		LittleBrother lit5 = new LittleBrother(8, 12);
		LittleBrother lit6 = new LittleBrother(9, 11);
		area.updateField(lit1.getX(), lit1.getY(), lit1.getName());
		area.updateField(lit2.getX(), lit2.getY(), lit2.getName());
		area.updateField(lit3.getX(), lit3.getY(), lit3.getName());
		area.updateField(lit4.getX(), lit4.getY(), lit4.getName());
		area.updateField(lit5.getX(), lit5.getY(), lit5.getName());
		area.updateField(lit6.getX(), lit6.getY(), lit6.getName());
		Scorpion sco = new Scorpion(7,10);
		area.updateField(sco.getX(), sco.getY(), sco.getName());
		Snake sna = new Snake(12, 13);
		area.updateField(sna.getX(), sna.getY(), sna.getName() + ":" + sna.cheerSnake());
	}
	
	public void craneFormation() {
		area.clearMonster();
		LittleBrother lit1 = new LittleBrother(5, 14);
		LittleBrother lit2 = new LittleBrother(6, 13);
		LittleBrother lit3 = new LittleBrother(7, 13);
		LittleBrother lit4 = new LittleBrother(8, 11);
		LittleBrother lit5 = new LittleBrother(9, 10);
		area.updateField(lit1.getX(), lit1.getY(), lit1.getName());
		area.updateField(lit2.getX(), lit2.getY(), lit2.getName());
		area.updateField(lit3.getX(), lit3.getY(), lit3.getName());
		area.updateField(lit4.getX(), lit4.getY(), lit4.getName());
		area.updateField(lit5.getX(), lit5.getY(), lit5.getName());
		Scorpion sco = new Scorpion(7, 9);
		area.updateField(sco.getX(), sco.getY(), sco.getName());
		Snake sna = new Snake(10, 13);
		area.updateField(sna.getX(), sna.getY(), sna.getName() + ":" + sna.cheerSnake());
	}
}