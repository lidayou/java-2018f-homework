import java.util.Random;

enum Color // the color of the brothers
{
    Red(1), Orange(2), Yellow(3), Green(4), Cyan(5), Blue(6), Purple(7);

    private int value;

    Color(int value)
    {
        this.value = value;
    }
    public int getValue()
    {
        return this.value;
    }
}

class SingleHuluBrother
{
    private Color color;
    private String name;

    SingleHuluBrother(Color color, String name){
        this.color = color;
        this.name = name;
    }
    public Color getColor()
    {
        return color;
    }
    public String getName()
    {
        return name;
    }
    public void SayName()
    {
        System.out.print(name + "  ");
    }
    public void SayColor()
    {
        switch (color)
        {
            case Red: System.out.print("红色 "); break;
            case Orange: System.out.print("橙色 "); break;
            case Yellow: System.out.print("黄色 "); break;
            case Green: System.out.print("绿色 "); break;
            case Cyan: System.out.print("青色 "); break;
            case Blue: System.out.print("蓝色 "); break;
            case Purple: System.out.print("紫色 "); break;
            default: break;
        }
    }
}

public class HuluBrothers
{
    private SingleHuluBrother[] Brothers;
    private static final int broNum = 7;

    HuluBrothers(){
        Brothers = new SingleHuluBrother[broNum];
        Brothers[0] = new SingleHuluBrother(Color.Red,"老大");
        Brothers[1] = new SingleHuluBrother(Color.Orange,"老二");
        Brothers[2] = new SingleHuluBrother(Color.Yellow,"老三");
        Brothers[3] = new SingleHuluBrother(Color.Green,"老四");
        Brothers[4] = new SingleHuluBrother(Color.Cyan,"老五");
        Brothers[5] = new SingleHuluBrother(Color.Blue,"老六");
        Brothers[6] = new SingleHuluBrother(Color.Purple,"老七");
    }

    private void NumberOffbyName()
    {
        System.out.print("报数： ");
        for (int i = 0; i < broNum; i++) {
            Brothers[i].SayName();
        }
        System.out.print('\n');
    }

    private void NumberOffbyColor()
    {
        System.out.print("报数： ");
        for (int i = 0; i < broNum; i++) {
            Brothers[i].SayColor();
        }
        System.out.print('\n');
    }

    public void Reordering()
    {
        // reorder the brothers sequence
        Random ranNum = new Random();
        for (int i = 0; i < broNum; i++)
        {
            int temp = ranNum.nextInt(i+1);
            SingleHuluBrother tempBro = Brothers[temp];
            Brothers[temp] = Brothers[i];
            Brothers[i] = tempBro;
        }
    }

    public void HuluBubbleSort()
    {
        for (int i = 0; i < broNum-1; i++) {
            for (int j = 0; j < broNum-1-i; j++) {
                if(Brothers[j].getColor().getValue() > Brothers[j+1].getColor().getValue())
                {
                    System.out.println(Brothers[j].getName() + (j+1) + "->" + (j+2));
                    System.out.println(Brothers[j+1].getName() + (j+2) + "->" + (j+1));
                    SingleHuluBrother temp = Brothers[j];
                    Brothers[j] = Brothers[j+1];
                    Brothers[j+1] = temp;
                }
            }
        }
        NumberOffbyName();
    }

    private void BiSort(int start , int end)
    {
        if(start >= end)
            return;
        int middle = (start + end) / 2;
        BiSort(start,middle);
        BiSort(middle+1,end);

        // merge the two result together
        int mergeNum = end - start + 1;
        SingleHuluBrother[] temp = new SingleHuluBrother[mergeNum];
        int n = 0; // the index of temp
        int n1 = start , n2 = middle+1;
        while((n1 != middle+1) && (n2 != end+1))
        {
            if(Brothers[n1].getColor().getValue() < Brothers[n2].getColor().getValue())
            {
                if(n1 != start + n)
                {
                    System.out.println(Brothers[n1].getName() + (n1+1) + "->" + (start+n+1));
                }
                temp[n] = Brothers[n1];
                n++; n1++;
            }
            else
            {
                if(n2 != start + n)
                {
                    System.out.println(Brothers[n2].getName() + (n2+1) + "->" + (start+n+1));
                }
                temp[n] = Brothers[n2];
                n++; n2++;
            }
        }
        if(n1 == middle+1)
        {
            while(n2 != end+1)
            {
                temp[n] = Brothers[n2];
                n++; n2++;
            }
        }
        else
        {
            while(n1 != middle+1)
            {
                System.out.println(Brothers[n1].getName() + (n1+1) + "->" + (start+n+1));
                temp[n] = Brothers[n1];
                n++; n1++;
            }
        }
        for (int i = 0; i < mergeNum; i++) {
            Brothers[start+i] = temp[i];
        }
    }

    public void HuluBinarySort()
    {
        BiSort(0,broNum-1);
        NumberOffbyColor();
    }

    public static void main(String[] args) {


        HuluBrothers bro = new HuluBrothers();
        bro.Reordering();
        bro.HuluBubbleSort();
        bro.Reordering();
        bro.HuluBinarySort();
    }
}

