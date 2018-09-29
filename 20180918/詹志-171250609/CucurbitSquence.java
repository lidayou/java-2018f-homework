import java.util.*;

class Cucurbit {
	private int status;
	private String colorOfCloth;
	private String strStatus;
	
	public Cucurbit(int status, String colorOfCloth, String strStatus) {
		this.status = status;
		this.colorOfCloth = colorOfCloth;
		this.strStatus = strStatus;
	}
	public String getStrStatus() {
		return strStatus;
	}
	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getColorOfCloth() {
		return colorOfCloth;
	}
	public void setStatus(String colorOfCloth) {
		this.colorOfCloth = colorOfCloth;
	}
	public void claimStatus() {
		System.out.println(status);
	}
	public void claimColorOfCloth() {
		System.out.println(colorOfCloth);
	}
}


public class CucurbitSquence {
	public Cucurbit[] bubleSort(Cucurbit[] cucurbit) {
		Cucurbit temp;
		for(int i = 0; i < (cucurbit.length-1); i++) {
			for(int j = 0; j < (cucurbit.length-1-i); j++){
				if(cucurbit[j].getStatus() > cucurbit[j+1].getStatus()) {
					temp = cucurbit[j];
					cucurbit[j] = cucurbit[j+1];
					cucurbit[j+1] = temp;
					System.out.println(cucurbit[j].getStrStatus() + ": " + j + " -> " + (j+1) );
				}
			}
		}
		return cucurbit;
	}
	
	
	public void claimSquenceStatus(Cucurbit[] cucurbit) {
		for(Cucurbit hero : cucurbit)
			System.out.print(hero.getStrStatus() + " ");
		System.out.println();
	}
	public void claimSquenceColorOfCloth(Cucurbit[] cucurbit) {
		for(Cucurbit hero : cucurbit)
			System.out.print(hero.getColorOfCloth() + " ");
		System.out.println();
	}
	
	
	public Cucurbit[] binarySearchSort(Cucurbit[] cucurbit) {
		ArrayList<Cucurbit> cucurbitList = new ArrayList<Cucurbit>();
		cucurbitList.add(0,cucurbit[0]);
		for(int i = 1; i < cucurbit.length; i++) {		 
				int high = i-1;
				int low = 0;
				
				while(low <= high) {
					int middle = (low + high) / 2;
					if(cucurbit[middle].getStatus() < cucurbit[i].getStatus())
						low = middle + 1;
					else 
						high = middle - 1;
				}
				cucurbitList.add(high+1, cucurbit[i]);
				for(int j = high; j < cucurbit.length; j++)
					System.out.println(cucurbit[j].getStrStatus() + ": " + j + " -> " + (j+1));
			
		}
		Cucurbit[] cucurbits = new Cucurbit[7];
		return cucurbitList.toArray(cucurbits);
	}
	public Cucurbit[] randomGenerate(Cucurbit[] cucurbits) {
		Cucurbit[] unsortCucurbits = new Cucurbit[7];
		Random rand = new Random(47);
		int[] randInt = new int[7];
		boolean continueGenerateInt = false;
		for(int i = 0; i < 7; i++) {
			do {
				randInt[i] = rand.nextInt(7);
				for(int j = 0; j < i; j++) {
					if(randInt[j] == randInt[i]) {
						continueGenerateInt = true;
						break;
					}
					if(randInt[j] != randInt[i])
						continueGenerateInt = false;
					}
			} while(continueGenerateInt);
		}
		for(int k = 0; k <= 6; k++) 
			unsortCucurbits[k] = cucurbits[randInt[k]];
		return unsortCucurbits;
	}
	public static void main(String[] args) {
		Cucurbit[] cucurbits = new Cucurbit[7];
		cucurbits[0] = new Cucurbit(0, "赤崽", "老大");
		cucurbits[1] = new Cucurbit(1, "橙崽", "老二");
		cucurbits[2] = new Cucurbit(2, "黄崽", "老三");
		cucurbits[3] = new Cucurbit(3, "绿崽", "老四");
		cucurbits[4] = new Cucurbit(4, "青崽", "老五");
		cucurbits[5] = new Cucurbit(5, "蓝崽", "六弟");
		cucurbits[6] = new Cucurbit(6, "紫崽", "小弟弟");
		CucurbitSquence cucurbitSquence = new CucurbitSquence();
		Cucurbit[] randomCucurbits = cucurbitSquence.randomGenerate(cucurbits);
		
		Cucurbit[] bubleSortedCucurbits = cucurbitSquence.bubleSort(randomCucurbits);
		cucurbitSquence.claimSquenceStatus(bubleSortedCucurbits);
		
		Cucurbit[] binarySortedCucurbits = cucurbitSquence.binarySearchSort(randomCucurbits);
		cucurbitSquence.claimSquenceColorOfCloth(binarySortedCucurbits);
	}
}
