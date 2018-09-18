import java.util.Random;

class CalabashBrothers{
	int status;
	int color;
	String statusname=new String();
	String colorname=new String();
	void set(int number){
		status=color=number;
		switch(status) {
			case 1:statusname="老大";colorname="红色";break;
			case 2:statusname="老二";colorname="橙色";break;
			case 3:statusname="老三";colorname="黄色";break;
			case 4:statusname="老四";colorname="绿色";break;
			case 5:statusname="老五";colorname="青色";break;
			case 6:statusname="老六";colorname="蓝色";break;
			case 7:statusname="老七";colorname="紫色";break;
			default:System.out.println("nonexistent");
		}
	}
	void talk(int sc){
		switch(sc) {
			case 0:
				System.out.println(statusname);break;
			case 1:
				System.out.println(colorname);break;
			default:
				System.out.println("nonexistent");
		}
	}
}

class Management {
	CalabashBrothers[] cala=new CalabashBrothers[7];
	public void randomize(int name) {
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
		System.out.print("随机排列:");
		switch(name) {
			case 1:{
				for(int i=0;i<7;i++)
					System.out.print(cala[i].statusname+" ");
			}break;
			case 2:{
				for(int i=0;i<7;i++)
					System.out.print(cala[i].colorname+" ");
			}
		}
		System.out.println("");
	}
	private void countoff(int name) {
		System.out.print("排序结果:");
		switch(name) {
			case 1:{
				for(int i=0;i<7;i++)
					System.out.print(cala[i].statusname);
			}break;
			case 2:{
				for(int i=0;i<7;i++)
					System.out.print(cala[i].colorname);
			}break;
			default:System.out.print("nonexistent");
		}
		System.out.println("");
	}
	public void sortbystatus() {
		System.out.println("冒泡法依照排行排序");
		int i,j;
		boolean exchange;
		for(i=0;i<6;i++) {
			exchange=false;
			for(j=6;j>i;j--) {
				if(cala[j].status<cala[j-1].status) {
					CalabashBrothers temp=cala[j];
					cala[j]=cala[j-1];
					cala[j-1]=temp;
					exchange=true;
					System.out.println(cala[j].statusname+":"+j+"->"+(j+1));
					System.out.println(cala[j-1].statusname+":"+(j+1)+"->"+j);
				}
			}
			if(!exchange)
				break;
		}
		countoff(1);
	}
	public void sortbycolor() {
		System.out.println("二分法依照颜色排序");
		int i;
		for(i=1;i<7;i++) {
			int left=0,right=i-1;
			while(left<=right) {
				int middle=(right+left)/2;
				if(cala[i].color<cala[middle].color)
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
					System.out.println(cala[j].colorname+":"+j+"->"+(j+1));
				}
				cala[left]=temp;
				System.out.println(cala[left].colorname+":"+(i+1)+"->"+(left+1));
			}
		}
		countoff(2);
	}
	Management(){
		for(int i=0;i<7;i++) {
			cala[i]=new CalabashBrothers();
			cala[i].set(i+1);
		}
	}
}

public class CalabashBrothersManagement{
	public static void main(String[] args) {
		Management m=new Management();
		m.randomize(1);
		m.sortbystatus();
		m.randomize(2);
		m.sortbycolor();
	}
}