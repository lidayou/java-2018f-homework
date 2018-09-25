package sort;
enum Color{
	红色,橙色,黄色,绿色,青色,蓝色,紫色;
}
public enum CalabashBrothers {
	One("老大",Color.红色),
	Two("老二",Color.橙色),
	Three("老三",Color.黄色),
	Four("老四",Color.绿色),
	Five("老五",Color.青色),
	Six("老六",Color.蓝色),
	Seven("老七",Color.紫色);
	
	private String name;
	private Color color;
	
	private CalabashBrothers(String n,Color c) {
		this.name = n;
		this.color = c;
	}
	
	public String getName() {
		return name;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void queueClaimName(CalabashBrothers[] Calabash) {
		System.out.println("\n报数开始");
		for(int i=0;i<Calabash.length;i++)
			System.out.println(Calabash[i].getName());
		System.out.println("报数结束\n");
	}
	
	public void queueClaimColor(CalabashBrothers[] Calabash) {
		System.out.println("\n报颜色开始");
		for(int i=0;i<Calabash.length;i++)
			System.out.println(Calabash[i].getColor());
		System.out.println("报颜色结束");
	}
	public void swapClaim(String people,int old_location,int new_location) {
		System.out.println(people+":"+old_location+"->"+new_location);
	}
	
	
}
