package javahw3;

public class Warrior implements Warriors {

	protected String name;
	protected String function;
	public int[] position;
	public String team;
	
	public Warrior(String name, String function, int team) {
		this.name = name;
		this.function = function;
		if(team==1)
			this.team = "GoodMan";
		else
			this.team = "BadMan";
		position = new int[2];
	}
	
	public String getName() {
		return name;
	}

	public String getFunction() {
		return function;
	}

	public int[] getPosition() {
		return position;
	}

	public void changePosiion(int m, int n) {
		position[0] = m;
		position[1] = n;
	}
	
	public String toString() {
		return name;
	}
	public void showMe() {
		System.out.println(name+" team:"+team+" ["+position[0]+","+position[1]+"]");
	}
	
}
