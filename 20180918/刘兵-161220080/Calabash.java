
public class Calabash
{
	public enum CalabashBrother {
		FIRST("老大","红色",1),SECOND("老二","橙色",2),THIRD("老三","黄色",3),FOURTH("老四","绿色",4),
		FIFTH("老五","青色",5),SIXTH("老六","蓝色",6),SEVENTH("老七","紫色",7);
		private final String name;
		private final String color;
		private final int rank;
		private CalabashBrother(String name,String color,int rank) {
			this.name=name;
			this.color=color;
			this.rank=rank;
		}
		public String getname() {
			return name;
		}
		public String getcolor() {
			return color;
		}
		public int getrank() {
			return rank;
		}
		public void moveposi(int now,int next) {
			System.out.println(name+":"+now+"->"+next);
		}
	}
	public static void Bubblesort(CalabashBrother[] cbs,int num) {
		for(int i=0;i<num;i++) {
			for(int j=i+1;j<num;j++) {
				if(cbs[i].rank>cbs[j].rank) {
					CalabashBrother tmp=cbs[i];
					cbs[i]=cbs[j];
					cbs[j]=tmp;
					cbs[j].moveposi(i, j);
				}
			}
		}
	}
	public static void merge(CalabashBrother[] cbs,int start,int mid,int end) {
		CalabashBrother[] tmp=new CalabashBrother[end-start+1];
		int i = start;                                               
		int j = mid+1;                                                                                                     
		int k = 0;	                                          
		while (i <= mid&&j <= end) {                                
			if (cbs[i].rank < cbs[j].rank) {
				tmp[k]=cbs[i];
				if(i!=k+start)
					tmp[k].moveposi(i,k);
				i++;
				k++;
				
			}
			else {
				tmp[k]=cbs[j];
				if(j!=k+start)
					tmp[k].moveposi(j,k);
				j++;
				k++;
			}
		}
		while (i <= mid) {
			tmp[k]=cbs[i];
			if(i!=k+start)
				tmp[k].moveposi(i,k);
			i++;
			k++;
		}
		while (j <= end) {
			tmp[k]=cbs[j];
			if(j!=k+start)
				tmp[k].moveposi(j,k);
			j++;
			k++;
		}
		for(int t=start;t<=end;t++)
			cbs[t]=tmp[t-start];
	}
	public static void mergesort(CalabashBrother[] cbs,int start,int end) {
		if(start<end) {
			int mid=(start+end)/2;
			mergesort(cbs,start,mid); 
			mergesort(cbs,mid+1,end);
			merge(cbs,start,mid,end);
		}
	}
	public static void main(String[] args) {
		CalabashBrother[] cbs1= {CalabashBrother.SIXTH,CalabashBrother.THIRD,CalabashBrother.SEVENTH,CalabashBrother.SECOND,CalabashBrother.FIRST,CalabashBrother.FIFTH,CalabashBrother.FOURTH};
		Bubblesort(cbs1,7);
		System.out.println("冒泡排序后结果：");
		for(int i=0;i<cbs1.length;i++) {
			System.out.println(cbs1[i].getname());
		}
		CalabashBrother[] cbs2= {CalabashBrother.FOURTH,CalabashBrother.THIRD,CalabashBrother.SEVENTH,CalabashBrother.SECOND,CalabashBrother.FIRST,CalabashBrother.SIXTH,CalabashBrother.FIFTH};
		mergesort(cbs2,0,6);
		System.out.println("二分法排序后结果：");
		for(int i=0;i<cbs2.length;i++) {
			System.out.println(cbs2[i].getcolor());
		}
	}
}
