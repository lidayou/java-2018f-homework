import java.util.Random;

class CalabashBrother
{
    private int number;
    private String name;
    private String color;
    CalabashBrother(int number, String name,String color)
    {
        this.number=number;
        this.color = color;
        this.name = name;
    }

    public int getNumber()
    {
        return number;
    }

    public String getName()
    {
        return name;
    }
    public String getColor()
    {
        return color;
    }
}

public class Sort {

    public static void rand_array(CalabashBrother[] gourds, int n)
    {
        Random rand = new Random();
        for(int i = n - 1;i >0;i--)
        {
            int rand_num = rand.nextInt(i);
            CalabashBrother temp = gourds[i];
            gourds[i] = gourds[rand_num];
            gourds[rand_num] = temp;
        }
    }

    public static void bubble_sort(CalabashBrother[] gourds, int n)
    {
        for(int i = 0;i < n;i++)
        {
            for(int j = 0;j< n - 1 - i;j++)
            {
                if(gourds[j].getNumber()>gourds[j+1].getNumber())
                {
                    System.out.print(gourds[j].getName()+": "+j+"->"+(j+1)+"  ");
                    System.out.println(gourds[j+1].getName()+": "+(j+1)+"->"+j);
                    CalabashBrother temp = gourds[j];
                    gourds[j] = gourds[j+1];
                    gourds[j+1] = temp;
                }
            }
        }
    }
    
    public static void binary_insert_sort(CalabashBrother[] a, int n)
    {
        for(int i = 1;i<n;i++)
        {
            CalabashBrother temp = a[i];
            int left = 0;
            int right = i -1;
            int mid = 0;
            while(left <= right)
            {
                mid = (left+right)/2;
                if(temp.getNumber()<a[mid].getNumber())
                    right = mid-1;
                else
                    left = mid+1;
            }
            for(int j = i - 1;j>=left;j--)
            {
                System.out.print(a[j].getName() + ": " + j + "->" + (j + 1) + "  ");
                a[j + 1] = a[j];
            }
            if(left != i)
            {
                System.out.print(temp.getName()+": "+i+"->"+left);
                a[left] = temp;
                System.out.println("");
            }

        }
    }

    public static void count_name(CalabashBrother[] gourds, int n)
    {
        for(int i=0;i<n;i++)
            System.out.print(gourds[i].getName()+" ");
        System.out.println("");
    }

    public static void count_color(CalabashBrother[] gourds, int n)
    {
        for(int i=0;i<n;i++)
            System.out.print(gourds[i].getColor()+" ");
        System.out.println("");
    }

    public static void main(String[] args)
    {
        int number = 7;
        CalabashBrother[] gourds = new CalabashBrother[number];
        int []numbers = {1,2,3,4,5,6,7};
        String[]name = {"老大","老二","老三","老四","老五","老六","老七"};
        String[]color = {"红色","橙色","黄色","绿色","青色","蓝色","紫色"};
        for(int i = 0;i<number;i++)
        {
            CalabashBrother s = new CalabashBrother(numbers[6-i],name[6-i],color[6-i]);
            gourds[i] = s;
        }

        System.out.print("---冒泡排序---\n"+"排序前：");
        rand_array(gourds,number);
        count_name(gourds,number);
        bubble_sort(gourds,number);
        System.out.print("排序后：");
        count_name(gourds,number);

        System.out.print("\n---二分插入排序---\n"+"排序前：");
        rand_array(gourds,number);
        count_color(gourds,number);
        binary_insert_sort(gourds, number);
        System.out.print("排序后：");
        count_color(gourds,number);
    }
}
