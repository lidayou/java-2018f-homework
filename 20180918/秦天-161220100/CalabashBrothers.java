import java.util.Random;

class Calabash {
	public Calabash(int rank) {
		this.rank = rank;
		switch (rank) {
		case 1:color="红色";rankName="老大";break;
		case 2:color="橙色";rankName="老二";break;
		case 3:color="黄色";rankName="老三";break;
		case 4:color="绿色";rankName="老四";break;
		case 5:color="青色";rankName="老五";break;
		case 6:color="蓝色";rankName="老六";break;
		case 7:color="紫色";rankName="老七";break;
		default:
		}
	}
	public void reportRank() {
		System.out.println(rankName);
	}
	public void reportColor() {
		System.out.println(color);
	}
	public void reportPositionChange(int pos1, int pos2) {
		System.out.println(rankName+"："+pos1+"->"+pos2);
	}
	public final int rank;
	private String color;
	private String rankName; 
}

public class CalabashBrothers {
	public Calabash[] brothers=new Calabash[7];
	public CalabashBrothers(){
		for(int i=0;i<7;i++)
			brothers[i]=new Calabash(i+1);
	}
	public void randomArrange() {
		Random random=new Random();
		for(int i=0;i<7;i++) {
			swap(random.nextInt(7), random.nextInt(7),false);
		}
	}
	public void bubbleSort() {
		for(int i=0;i<brothers.length-1;i++) {
			for(int j=0;j<brothers.length-1-i;j++) {
				if(brothers[j].rank>brothers[j+1].rank) {
					swap(j, j+1, true);
				}
			}
		}
	}
	public void binarySort() {
		for(int i=1;i<brothers.length;i++) {
			int left=0,right=i-1;
			Calabash tmp=brothers[i];
			while(left<=right) {
				int mid=(left+right)/2;
				if(brothers[mid].rank>tmp.rank)
					right=mid-1;
				else
					left=mid+1;
			}
			for(int j=i-1;j>right;j--) {
				brothers[j+1].reportPositionChange(j+1, j);
				brothers[j+1]=brothers[j];
			}
			brothers[right+1]=tmp;
		}
	}
	public void reportRanks() {
		System.out.println();
		for(Calabash x:brothers)
			x.reportRank();
		System.out.println();
	}
	public void reportColors() {
		System.out.println();
		for(Calabash x:brothers)
			x.reportColor();
		System.out.println();
	}
	private void swap(int pos1, int pos2, boolean report) {
		if(report) {
			brothers[pos1].reportPositionChange(pos1, pos2);
			brothers[pos2].reportPositionChange(pos2, pos1);
		}
		Calabash tmp=brothers[pos1];
		brothers[pos1]=brothers[pos2];
		brothers[pos2]=tmp;
	}
	public static void main(String[] args) {
		CalabashBrothers cBrothers=new CalabashBrothers();
		cBrothers.randomArrange();
		cBrothers.bubbleSort();
		cBrothers.reportRanks();
		cBrothers.randomArrange();
		cBrothers.binarySort();;
		cBrothers.reportColors();
	}

}
