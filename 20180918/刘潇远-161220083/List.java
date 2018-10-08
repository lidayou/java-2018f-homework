import java.io.*;
enum CalabashBrother{
	RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE;
	String[] NAME = {"老大", "老二", "老三", "老四", "老五", "老六", "老七"};
	String[] COLOR = {"赤", "橙", "黄", "绿", "青", "蓝", "紫"};
	String getName() {
		return this.NAME[ordinal()];
	}
	String getColor() {
		return this.COLOR[ordinal()];
	}
}

class CalabashBrothers{
	CalabashBrother[] calabashbrothers = new CalabashBrother[7];
	CalabashBrothers(){
		Disorder();
/*
		boolean[] existence= {false, false, false, false, false, false, false};
		for(int i = 0; i < 7; i++) {
			int tmp;
			do {
				tmp = (int)(Math.random()*7);
			}while(existence[tmp]);
			calabashbrothers[i]=CalabashBrother.values()[tmp];
			existence[tmp]=true;
		}
*/
	}
	void SwapBrother(int index1, int index2) {
		System.out.println(calabashbrothers[index1].getName()+":"+ index1 + "->" + index2);
		System.out.println(calabashbrothers[index2].getName()+":" + index2 + "->" + index1);
		CalabashBrother swaper = calabashbrothers[index1];
		calabashbrothers[index1] = calabashbrothers[index2];
		calabashbrothers[index2] = swaper;
	}
	CalabashBrother getBrother(int index) {
		return calabashbrothers[index];
	}
	String getName(int index) {
		//System.out.print(calabashbrothers[index].getName());
		return calabashbrothers[index].getName();
	}
	String getColor(int index) {
		//System.out.print(calabashbrothers[index].getColor());
		return calabashbrothers[index].getColor();
	}
	public void QueueNameStatus() {//按名输出队列当前序
		for(int i = 0;i<7;i++) {
			System.out.print(calabashbrothers[i].getName() + " ");
		}
		System.out.println("");
	}
	public void QueueColorStatus() {//按颜色输出队列当前序
		for(int i = 0;i<7;i++) {
			System.out.print(calabashbrothers[i].getColor() + " ");
		}
		System.out.println("");
	}
	public void Disorder() {
		boolean[] existence= {false, false, false, false, false, false, false};
		for(int i = 0; i < 7; i++) {
			int tmp;
			do {
				tmp = (int)(Math.random()*7);
			}while(existence[tmp]);
			calabashbrothers[i]=CalabashBrother.values()[tmp];
			existence[tmp]=true;
		}
	}
}

class Director{
	/*
	private CalabashBrothers calabashbrothers = new CalabashBrothers();
	
	public void QueueNameStatus() {//按名输出队列当前序
		for(int i = 0;i<7;i++) {
			System.out.print(calabashbrothers.getName(i) + " ");
		}
	}
	public void QueueColorStatus() {//按颜色输出队列当前序
		for(int i = 0;i<7;i++) {
			System.out.print(calabashbrothers.getColor(i) + " ");
		}
	}
	*/
	public void QueueNameStatus(CalabashBrothers calabashbrothers) {
		calabashbrothers.QueueNameStatus();
	}
	public void QueueColorStatus(CalabashBrothers calabashbrothers) {
		calabashbrothers.QueueColorStatus();
	}
	public void BubbleSort(CalabashBrothers calabashbrothers) {
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 6 - i; j++) {
				if(calabashbrothers.getBrother(j).compareTo(calabashbrothers.getBrother(j + 1))>0) {
					
					calabashbrothers.SwapBrother(j, j + 1);
					
				}
			}
		}
	}
	private int Partition(CalabashBrothers calabashbrothers, int p, int r){
		CalabashBrother pivot= calabashbrothers.getBrother(r);
		int i = p - 1;
		for(int j = p; j < r;j++){
			if(calabashbrothers.getBrother(j).compareTo(pivot) < 0){
				i++;
				calabashbrothers.SwapBrother(i, j);
			}
		}
		calabashbrothers.SwapBrother(r, i + 1);
		//elements[r] = elements[i + 1]
		//elements[i + 1] = pivot;
		return i + 1;
	}
	public void QuickSort(CalabashBrothers calabashbrothers, int p, int r) {
		if(p < r) {
			int q = Partition(calabashbrothers, p, r);
			QuickSort(calabashbrothers, p, q - 1);
			QuickSort(calabashbrothers, q + 1, r);
		}
	}
}

public class List {
	
	public static void main(String args[]) {
	Director director = new Director();
	
	CalabashBrothers calabashbrothers = new CalabashBrothers();
	calabashbrothers.QueueNameStatus();
	calabashbrothers.QueueColorStatus();
	
	director.BubbleSort(calabashbrothers);
	calabashbrothers.QueueNameStatus();
	calabashbrothers.QueueColorStatus();
	
	calabashbrothers.Disorder();
	calabashbrothers.QueueNameStatus();
	calabashbrothers.QueueColorStatus();
	
	director.QuickSort(calabashbrothers, 0, 6);
	calabashbrothers.QueueNameStatus();
	calabashbrothers.QueueColorStatus();
	}
}
