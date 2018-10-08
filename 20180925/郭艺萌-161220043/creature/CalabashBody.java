package creature;

public class CalabashBody extends Creature {
	public enum COLOR {RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE}
	public enum NAME {老大, 老二, 老三, 老四, 老五, 老六, 老七}
	
	private int no;
    private NAME name;
    private COLOR color;
    
    public CalabashBody(int no) {
    	this.no = no;
    	this.name = NAME.values()[no];
    	this.color = COLOR.values()[no];
    }
    public int getNo() {
    	return no;
    }
    public NAME getName() {
        return name;
    }
    public COLOR getColor() {
    	return color;
    }

}