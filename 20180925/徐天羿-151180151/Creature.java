package calabash;

public class Creature {
	String name;
	int x,y;
	
	Creature(){
		x = 0;
		y = 0;
		name = "unknown";
	}
	
	Creature(String name, int x, int y, int mark){
		this.name = name;
		this.x = x;
		this.y = y;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void reportName() {
		System.out.print(getName() + "\t");
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
}

class Calabash extends Creature{
	int mark;
	
	Calabash(int i, int x, int y){
		this.x = x;
		this.y = y;
		if(i ==0) {
			name = "大娃";
			mark = 1;
		}
		else if(i ==1) {
			name = "二娃";
			mark = 2;
		}
		else if(i ==2) {
			name = "三娃";
			mark = 3;
		}
		else if(i ==3) {
			name = "四娃";
			mark = 4;
		}
		else if(i ==4) {
			name = "五娃";
			mark = 5;
		}
		else if(i ==5) {
			name = "六娃";
			mark = 6;
		}
		else if(i ==6) {
			name = "七娃";
			mark = 7;
		}
	}
}

class Grandfather extends Creature{
	Grandfather(int x, int y){
		this.name = "爷爷";
		this.x = x;
		this.y = y;
	}
	
	public String cheerGrand() {
		return "孩子们冲鸭!";
	}
}

class LittleBrother extends Creature{
	LittleBrother(int x, int y){
		this.name = "小老弟";
		this.x = x;
		this.y = y;
	}
}

class Scorpion extends Creature{
	Scorpion(int x, int y){
		this.name = "蝎子精";
		this.x = x;
		this.y = y;
	}
}

class Snake extends Creature{
	Snake(int x, int y){
		this.name = "蛇精";
		this.x = x;
		this.y = y;
	}
	
	public String cheerSnake() {
		return "你们怎么肥四，小老弟?";
	}
}