import java.util.Random;

public class HuLuWas {
	private HuLuWa[] hulu;
	private Random random;
	HuLuWas(){
		random=new Random();
		hulu=new HuLuWa[]{
			new HuLuWa("老大", 1, Color.RED),
			new HuLuWa("老二", 2, Color.ORANGE),
			new HuLuWa("老三", 3, Color.YELLOW),
			new HuLuWa("老四", 4, Color.GREEN),
			new HuLuWa("老五", 5, Color.CYAN),
			new HuLuWa("老六", 6, Color.BLUE),
			new HuLuWa("老七", 7, Color.PURPLR),};
	}
	
	//七兄弟随机站队
	public void randomStand() {
		for(int i=0;i<hulu.length;i++){
			int rnd=random.nextInt(hulu.length-i); //[0,hulu.length-i)
			HuLuWa temp=hulu[rnd];
			hulu[rnd]=hulu[hulu.length-i-1];
			hulu[hulu.length-i-1]=temp;
		}
		
	}
	//七兄弟按照id冒泡排序
	public void bubbleSortId(){
		for(int count=0;count<hulu.length-1;count++){
			boolean exchange=false;
			for(int i=0;i<hulu.length-1-count;i++){
				if(hulu[i].huluCompareId(hulu[i+1])>0){
					exchange(i,i+1);
					exchange=true;
				}
			}
			if(exchange==false)
				break;
		}	
	}
	//七兄弟按照颜色二分排序
	public void binarySort(){
		for(int i=1;i<hulu.length;i++){
			int index=0;
			int start=0;
			int end=i;	//[start,end)
			while(start<end){
				int middle=(start+end)/2;
				if(hulu[i].huluCompareColor(hulu[middle])<0){
					end=middle;
				}
				else if(hulu[i].huluCompareColor(hulu[middle])>=0){
					start=middle+1;
				}
			}
			//start==end
			index=start;
			HuLuWa temp=hulu[i];
			System.out.println("at this position change:");
			for(int j=i-1;j>=index;j--){
				System.out.println(hulu[j].getName()+":"+hulu[j].getId()+"->"+hulu[j+1].getId());
				hulu[j+1]=hulu[j];
			}
			System.out.println(temp.getName()+":"+temp.getId()+"->"+hulu[index].getId());
			hulu[index]=temp;
			System.out.println("end position change.");
		}		
	}
	private void exchange(int a,int b){
		System.out.println("at this position change:");
		System.out.println(hulu[a].getName()+":"+hulu[a].getId()+"->"+hulu[b].getId());
		System.out.println(hulu[b].getName()+":"+hulu[b].getId()+"->"+hulu[a].getId());
		System.out.println("end position change.");
		HuLuWa c=hulu[b];
		hulu[b]=hulu[a];
		hulu[a]=c;
	}
	public void speakName(){
		for(HuLuWa a:hulu){
			System.out.print(a.getName()+" ");
		}
		System.out.println("");
	}
	public void speakColor(){
		for(HuLuWa a:hulu){
			System.out.print(a.getColor()+" ");
		}
		System.out.println("");
	}
}
