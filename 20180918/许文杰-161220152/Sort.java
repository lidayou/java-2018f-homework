import java.util.Random;

class Gourd
{
    public int number;
    private String name;
    private String color;
    Gourd(int number, String name,String color)
    {
        this.number=number;
        this.color = color;
        this.name = name;
    }
    /*public void set(int number, String name,String color)
    {
        this.number=number;
        this.color = color;
        this.name = name;
    }*/
    public void print_name()
    {
        System.out.print(name);
    }
    public void print_color()
    {
        System.out.print(color);
    }
}

public class Sort {

    public static void rand_array(Gourd[] gourds, int n)
    {
        Random rand = new Random();
        for(int i = n - 1;i >0;i--)
        {
            int rand_num = rand.nextInt(i);
            //System.out.println(rand_num);
            Gourd temp = gourds[i];
            gourds[i] = gourds[rand_num];
            gourds[rand_num] = temp;
        }
    }

    public static void bubble_sort(Gourd[] gourds, int n)
    {
        for(int i = 0;i < n;i++)
        {
            for(int j = 0;j< n - 1 - i;j++)
            {
                if(gourds[j].number>gourds[j+1].number)
                {
                    gourds[j].print_name();
                    System.out.print(": "+j+"->"+(j+1)+"  ");
                    gourds[j+1].print_name();
                    System.out.println(": "+(j+1)+"->"+j);

                    Gourd temp = gourds[j];
                    gourds[j] = gourds[j+1];
                    gourds[j+1] = temp;
                }
            }
        }
    }

    public static void merge(Gourd[] gourds,int begin,int mid, int end)
    {
        if(begin >= end)
            return;
        Gourd[] temp = new Gourd[mid-begin+1];
        for(int i = 0;i<mid-begin+1;i++)//将前半部分拷贝到另一数组
        {
            //Gourd tmp = gourds[begin+i];
            temp[i] = gourds[begin+i];
        }
        //for(int i = 0;i<mid-begin+1;i++)//将前半部分拷贝到另一数组
        //{
            //Gourd tmp = gourds[begin+i];
        //    System.out.print(temp[i].number+" ");
       // }
        //System.out.println("");
        int i = 0,j = mid+1, k = begin;
        //System.out.println(begin+" "+mid+" "+end);
        while(i<=(mid-begin)&&j<=end)
        {
            if(temp[i].number<gourds[j].number)
            {
                temp[i].print_name();
                System.out.println(": "+(begin+i)+"->"+k);
                gourds[k] = temp[i];
                i++;
            }
            else
            {
                gourds[k].print_name();
                System.out.println(": "+j+"->"+k);
                gourds[k] = gourds[j];
                j++;
            }
            k++;
        }

        while(i<=mid-begin)
        {
            gourds[k] = temp[i];
            k++;
            i++;
        }
    }

    public static void merge_sort(Gourd[] gourds, int begin, int end)
    {
        int mid;
        if(begin<end)
        {
            mid = (begin+end)/2;
            merge_sort(gourds, begin, mid);
            merge_sort(gourds, mid+1,end);
            merge(gourds,begin,mid,end);
        }
    }

    public static int partition(Gourd []a,int p,int q)
    {
        Gourd pivot = a[p];
        int i = p,j = q;
        while(i<j)
        {
            while(i<j && a[j].number > pivot.number)
                j--;
            if(i != j) {
                a[i].print_name();
                System.out.print(": " + i + "->" + j + "  ");
                a[j].print_name();
                System.out.print(": " + j + "->" + i + "\n");
            }
            a[i] = a[j];

            while(i<j && a[i].number <= pivot.number)
                i++;
            if(i !=j) {
                a[j].print_name();
                System.out.print(": " + j + "->" + i + "  ");
                a[i].print_name();
                System.out.print(": " + i + "->" + j + "\n");
            }

            a[j] = a[i];
        }
        a[i] = pivot;
        return i;
    }

    public static void quick_sort(Gourd []a, int p, int q)
    {
        if(p>=q)
            return;
        int mid = partition(a,p,q);
        quick_sort(a,p,mid-1);
        quick_sort(a,mid+1,q);
    }

    public static void count_name(Gourd[] gourds, int n)
    {
        for(int i=0;i<n;i++)
        {
            gourds[i].print_name();
            System.out.print(" ");
        }
        System.out.println("");
    }

    public static void count_color(Gourd[] gourds, int n)
    {
        for(int i=0;i<n;i++)
        {
            gourds[i].print_color();
            System.out.print(" ");
        }
        System.out.println("");
    }

    public static void main(String[] args)
    {
        int number = 7;
        Gourd[] gourds = new Gourd[number];
        int []numbers = {1,2,3,4,5,6,7};
        String[]name = {"老大","老二","老三","老四","老五","老六","老七"};
        String[]color = {"红色","橙色","黄色","绿色","青色","蓝色","紫色"};
        for(int i = 0;i<number;i++)
        {
            Gourd s = new Gourd(numbers[6-i],name[6-i],color[6-i]);
            gourds[i] = s;
        }
        rand_array(gourds,number);
        count_name(gourds,number);
        bubble_sort(gourds,number);
        count_name(gourds,number);

        rand_array(gourds,number);
        count_color(gourds,number);
        quick_sort(gourds, 0, number-1);
        count_color(gourds,number);
    }
}
