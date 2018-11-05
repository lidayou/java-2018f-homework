package javahw3;

import java.util.ArrayList;

public class Team{
	/*
	 * Variables: ArrayList<Warrior> team;
	 * Methods: showWarriors();
	 * check the team member to ensure no enemy
	 * */
	public ArrayList<Warrior> team;
	private String side;
	Team(String side){
		team = new ArrayList<Warrior>();
		this.side = side;
	}
	public void showWarriors() {
		for(Warrior k:team)
			k.showMe();
	}
	public String getSide() {
		return side;
	}
	public void add(Warrior obj) {
		team.add(obj);
	}
	
	public void checkMember() throws MyException{
		for(Warrior w: team) {
			try {
				if(w.getTeam() != side)
					throwMyException(w.getName());
			}catch(MyException e){
				w.changeTeam(side);
				System.out.println("changed the spy!");
			}	
		}
	}
	
	public void throwMyException(String name) throws MyException{
		throw new MyException(name + " is a spy in " + side);
	}
}