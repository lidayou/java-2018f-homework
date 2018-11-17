package javahw3;

public interface TeamInterface {
	abstract public String toString();
	abstract public void showTeam() ;
	
	abstract public String getSide();
	abstract public void add(Warrior temp);
	abstract public void goBattle(Warrior [][] fields, int[][] place);
	abstract public void checkMember() throws MyException;

}
