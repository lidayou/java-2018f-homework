import java.util.Random;

enum Color{
	RED("红色"),ORANGE("橙色"),YELLOW("黄色"),GREEN("绿色"),CYAN("青色"),BLUE("蓝色"),PURPLE("紫色");
	String color;
	Color(String color){
		this.color=color;
	}
	public String toString() {
		return color;
	}
}

enum Status{
	FIRST("老大"),SECOND("老二"),THIRD("老三"),FOURTH("老四"),FIFTH("老五"),SIXTH("老六"),SEVENTH("老七");
	String status;
	Status(String status){
		this.status=status;
	}
	public String toString() {
		return status;
	}
}

class CalabashBrothers{
	private Status status;
	private Color color;
	CalabashBrothers(int number){
		switch(number) {
			case 1:color=Color.RED;status=Status.FIRST;break;
			case 2:color=Color.ORANGE;status=Status.SECOND;break;
			case 3:color=Color.YELLOW;status=Status.THIRD;break;
			case 4:color=Color.GREEN;status=Status.FOURTH;break;
			case 5:color=Color.CYAN;status=Status.FIFTH;break;
			case 6:color=Color.BLUE;status=Status.SIXTH;break;
			case 7:color=Color.PURPLE;status=Status.SEVENTH;break;
			default:System.out.println("nonexistent");
		}
	}
	String statusstring() {
		return status.toString();
	}
	String colorstring() {
		return color.toString();
	}
	int statusnumber() {
		return status.ordinal();
	}
	int colornumber() {
		return color.ordinal();
	}
}

class Management {
	CalabashBrothers[] cala=new CalabashBrothers[7];
	Management(){
		for(int i=0;i<7;i++)
			cala[i]=new CalabashBrothers(i+1);
	}
	public void randomize() {
		Random random=new Random();
		for(int i=0;i<20;i++) {
			int x=random.nextInt(6);
			int y=random.nextInt(6);
			if(x!=y) {
				//将x位置和y位置的葫芦娃交换
				CalabashBrothers temp = cala[x];
				cala[x]=cala[y];
				cala[y]=temp;
			}
		}
	}
	public void countoff(int name) {
		switch(name) {
			case 1:{//按照排行报数
				for(int i=0;i<7;i++)
					System.out.print(cala[i].statusstring());
			}break;
			case 2:{//按照颜色报数
				for(int i=0;i<7;i++)
					System.out.print(cala[i].colorstring());
			}break;
			default:System.out.print("nonexistent");
		}
		System.out.println("");
	}
	private void tellstatuschange(int number,int x,int y) {
		System.out.println(cala[number].statusstring()+":"+x+"->"+y);
	}
	private void tellcolorchange(int number,int x,int y) {
		System.out.println(cala[number].colorstring()+":"+x+"->"+y);
	}
	public void sortbystatus() {
		System.out.println("冒泡法依照排行排序");
		int i,j;
		boolean exchange;
		for(i=0;i<6;i++) {
			exchange=false;
			for(j=6;j>i;j--) {
				if(cala[j].statusnumber()<cala[j-1].statusnumber()) {
					CalabashBrothers temp=cala[j];
					cala[j]=cala[j-1];
					cala[j-1]=temp;
					exchange=true;
					tellstatuschange(j,j,j+1);
					tellstatuschange(j-1,j+1,j);
				}
			}
			if(!exchange)
				break;
		}
	}
	public void sortbycolor() {
		System.out.println("二分法依照颜色排序");
		int i;
		for(i=1;i<7;i++) {
			int left=0,right=i-1;
			while(left<=right) {
				int middle=(right+left)/2;
				if(cala[i].colornumber()<cala[middle].colornumber())
					right=middle-1;
				else
					left=middle+1;
			}
			//插到left位置
			if(i!=left) {
				//将left到i-1之间的所有数往右移
				CalabashBrothers temp=cala[i];
				for(int j=i;j>=left+1;j--) {
					cala[j]=cala[j-1];
					tellcolorchange(j,j,j+1);
				}
				cala[left]=temp;
				tellcolorchange(left,i+1,left+1);
			}
		}
	}
}

public class CalabashBrothersManagement{
	public static void main(String[] args) {
		Management m=new Management();
		m.randomize();
		System.out.print("随机化结果: ");
		m.countoff(1);
		m.sortbystatus();
		System.out.print("排序结果: ");
		m.countoff(1);
		m.randomize();
		System.out.print("随机化结果: ");
		m.countoff(2);
		m.sortbycolor();
		System.out.print("排序结果: ");
		m.countoff(2);
	}
}