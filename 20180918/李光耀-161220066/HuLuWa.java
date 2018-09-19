
enum Color{
	RED,ORANGE,YELLOW,GREEN,CYAN,BLUE,PURPLR;
	@Override
	public String toString(){
		if(this==Color.RED)
			return "红色";
		else if(this==Color.ORANGE)
			return "橙色";
		else if(this==Color.YELLOW)
			return "黄色";
		else if(this==Color.GREEN)
			return "绿色";
		else if(this==Color.CYAN)
			return "青色";
		else if(this==Color.BLUE)
			return "蓝色";
		else if(this==Color.PURPLR)
			return "紫色";
		return "";
	}
}

public class HuLuWa {
	private String name;
	private int id;
	private Color color;
	public HuLuWa(String name,int id,Color color) {
		this.color=color;
		this.id=id;
		this.name=new String(name);
	}
	public int getId(){
		return id;
	}
	public Color getColor(){
		return color;
	}
	public String getName(){
		return name;
	}
	public int huluCompareId(HuLuWa b){
		if(this.getId()<b.getId())
			return -1;
		else if(this.getId()==b.getId())
			return 0;
		else {
			return 1;
		}
	}
	public int huluCompareColor(HuLuWa b) {
		return this.getColor().compareTo(b.getColor());
	}
}
