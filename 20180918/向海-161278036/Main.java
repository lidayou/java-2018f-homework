package sort;

public class Main {
	public static void main(String args[]) {
		CalabashBrothers[] Calabash = new CalabashBrothers[7];
		Sort sort=new Sort();
		int i=0;
		for(CalabashBrothers h: CalabashBrothers.values()) {
			Calabash[i++]=h;
		}
		sort.RandomSort(Calabash);
		Calabash[0].queueClaimName(Calabash);
		sort.BubbleSort(Calabash);
		Calabash[0].queueClaimName(Calabash);
		sort.RandomSort(Calabash);
		Calabash[0].queueClaimName(Calabash);
		sort.BinarySort(Calabash);		
		Calabash[0].queueClaimColor(Calabash);
	}
}