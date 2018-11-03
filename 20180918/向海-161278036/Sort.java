package sort;
import java.util.Random;
public class Sort {
	Random random = new Random();
		public void RandomSort(CalabashBrothers[] Calabash) {
			System.out.println("初始化队列开始");
			for(int i=0;i<Calabash.length;i++) {
				int p=random.nextInt(i+1);
				CalabashBrothers temp=Calabash[i];
				Calabash[i]=Calabash[p];
				Calabash[p]=temp;
			}
			System.out.println("初始化队列结束");
		}
		
		public void BubbleSort(CalabashBrothers[] Calabash) {
			System.out.println("\n冒泡排序开始");
			for(int i=0;i<Calabash.length;i++) {
				for(int j=i+1;j<Calabash.length;j++) {
					if(Calabash[i].ordinal()>Calabash[j].ordinal()) {
						Calabash[i].swapClaim(Calabash[i].getName(), i, j);
						CalabashBrothers Temp=Calabash[i];
						Calabash[i]=Calabash[j];
						Calabash[j]=Temp;
					}
				}
			}
			System.out.println("冒泡排序结束");
		}
		
		public void BinarySort(CalabashBrothers[] Calabash) {
			System.out.println("\n二分排序开始");
			for(int i=1;i<Calabash.length;i++) {
				CalabashBrothers temp=Calabash[i];
				int temp_old_location=i;
				int low=0,high=i-1;
				int mid=-1;
				while(low<high) {
					mid=low+(high-low)/2;
					if(temp.getColor().ordinal()<Calabash[mid].getColor().ordinal()) 
						high=mid-1;
					else
						low=mid+1;
				}
				for(int j=i-1;j>=low;j--) {
					Calabash[j+1]=Calabash[j];
				}
				Calabash[low]=temp;
				Calabash[low].swapClaim(Calabash[low].getName(),temp_old_location,low);
			}
			System.out.println("二分排序结束");
		}
		
		
}