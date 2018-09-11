import java.util.Random;
public class MySort {
	static void swap(int nums[],int id1,int id2) {
		int temp=nums[id1];
		nums[id1]=nums[id2];
		nums[id2]=temp;
	}
	static void quicksort(int nums[],int left,int right) {
		if(left>=right-1)return;
		int pivot=nums[left],pos=left;
		for(int i=left+1;i<right;i++) {
			if(nums[i]<pivot) {
				swap(nums, pos, i);
				pos++;
			}
		}
		nums[pos]=pivot;
		quicksort(nums, pos+1, right);
		quicksort(nums, left, pos);
	}
	public static void main(String args[]) {
		int a[]=new int[20];
		Random random=new Random();
		for(int i=0;i<a.length;i++) {
			a[i]=random.nextInt(100);
		}
		quicksort(a,0,a.length);
		for(int x:a)System.out.println(x);
	}
}
