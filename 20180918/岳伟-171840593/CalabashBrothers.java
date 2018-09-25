package hello;
import java.util.ArrayList;
import java.util.Random;
public enum  CalabashBrothers 
{
	R("老大",1,"红色"),O("老二",2,"橙色"),Y("老三",3,"黄色"),G("老四",4,"绿色"),C("老五",5,"青色"),B("老六",6,"蓝色"),P("老七",7,"紫色"),;
    private int rank;
    private String colour;
	private String name;
    private CalabashBrothers(String name,int rank,String colour)
   {
	this.name=name;
	this.rank=rank;
	this.colour=colour;
   }
    static void bubblesort(CalabashBrothers []bros,int number)
    {
     int i=0,j=0;
     CalabashBrothers temp;
     for(i=0;i<number-1;i++)
     {
    	 for(j=0;j<number-1-i;j++)
    	 {
    		 if(bros[j].rank>bros[j+1].rank)
    		 {
    			System.out.println(bros[j].name+":"+(j+1)+"->"+(j+2));
    			temp=bros[j];
    			bros[j]=bros[j+1];
    			bros[j+1]=temp;
    		 }
    	 }
     }
    }
    static void binarysort(CalabashBrothers[] bros,int number)
    {
        for (int i = 1; i < number; i++) 
        {   
        	int temp = bros[i].rank;
            int low = 0, high = i - 1;
            int mid = -1;
            while (low <= high) 
            {            
                mid = low + (high - low) / 2;            
                if (bros[mid].rank > temp) 
                {               
                    high = mid - 1;            
                } else 
                { // 元素相同时，也插入在后面的位置                
                    low = mid + 1;            
                }        
            }        
            CalabashBrothers change=bros[i];
            for(int j = i - 1; j >= low; j--) 
            {            
                bros[j + 1]= bros[j];        
            }        
            bros[low]=change;   
            System.out.println(change.name+":"+(i+1)+"->"+(low+1));
        }
    }
    static void shuffle(CalabashBrothers []bros,int number)
    {
		Random random = new Random();
        for(int i=0;i<7;i++)
        {
        	int index=random.nextInt(7);
        	CalabashBrothers temp;
        	temp=bros[i];
        	bros[i]=bros[index];
        	bros[index]=temp;
        }
	}
    
    
	public static void main(String[] args) 
	{
		int i=0;
		CalabashBrothers[] bros= {R,O,Y,G,C,B,P};
		System.out.println("冒泡排序：");
		shuffle(bros,7);
		System.out.print("排序前：");
		for(i=0;i<7;i++)
		{
			System.out.print(bros[i].name+" ");
		}
		System.out.println();
		bubblesort(bros,7);
		for(i=0;i<7;i++)
		{
			System.out.println(bros[i].name);
		}
		System.out.println();
		System.out.println("二分法排序：");
		shuffle(bros,7);
		System.out.print("排序前：");
		for(i=0;i<7;i++)
		{
			System.out.print(bros[i].name+" ");
		}
		System.out.println();
		binarysort(bros,7);
		for(i=0;i<7;i++)
		{
			System.out.println(bros[i].colour);
		}
	}
}
