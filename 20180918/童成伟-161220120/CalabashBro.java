package homework2;

enum Name {老大,老二,老三,老四,老五,老六,老七}
enum Color {红色,橙色,黄色,绿色,青色,蓝色,紫色}

 public class CalabashBro {
	public Color brocolor;
	public Name broname;
	//构造函数初始化
	CalabashBro(Name name, Color color){
		this.broname = name;
		this.brocolor = color;
	}
	//打印葫芦娃名字
	public void printname(){
		System.out.print(broname+ " ");
	}
	//打印葫芦娃颜色
	public void printcolor(){
		System.out.print(brocolor+ " ");
	}
	//打印位置变化
	public void printPoschange(int Old,int New)
	{
		 System.out.println(broname+":"+Old+"->"+New);
	}

}