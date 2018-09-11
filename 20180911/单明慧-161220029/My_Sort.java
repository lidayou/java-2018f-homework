package my_sort;
class Sort{
			int[] ArrayToSort= {5,3,7,1,2,9,10,4,6,8};
			void QuickSortEntry()
			{
				QuickSort(ArrayToSort,0,9);
				for(int i=0;i<10;i++)
				{
					System.out.println(ArrayToSort[i]);
				}
			}
			private void QuickSort(int[] ArrayToSort,int m,int n) {
				if(m>=n)
					return;
				else
				{
					int pivot=ArrayToSort[m];
					int left=m,right=n;
					while(left<right)
					{
						while(left<right&&ArrayToSort[right]>pivot)
						{
							right--;
						}
						ArrayToSort[left]=ArrayToSort[right];
						while(left<right&&ArrayToSort[left]<pivot)
						{
							left++;
						}
						ArrayToSort[right]=ArrayToSort[left];
					}
					ArrayToSort[left]=pivot;
					QuickSort(ArrayToSort,m,left-1);
					QuickSort(ArrayToSort,left+1,n);
				}
			}
}
public class My_Sort {
		
		public static void main(String[] args)
		{
			Sort test=new Sort(); 
			test.QuickSortEntry();
			return;
		}
}



