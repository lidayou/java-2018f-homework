package qx;

public class CalabashBrothers {
    public Calabash[] brothers;
    public CalabashBrothers()
    {
        brothers=new Calabash[7];
        brothers[0]=new Calabash(-1,-1,4,"老四");
        brothers[1]=new Calabash(-1,-1,7,"老七");
        brothers[2]=new Calabash(-1,-1,2,"老二");
        brothers[3]=new Calabash(-1,-1,1,"老大");
        brothers[4]=new Calabash(-1,-1,6,"老六");
        brothers[5]=new Calabash(-1,-1,3,"老三");
        brothers[6]=new Calabash(-1,-1,5,"老五");
    }
    public void BubbleSort()
    {
        for(int i=0;i<brothers.length-1;i++) {
            for (int j = 0; j < brothers.length - 1 - i; j++) {
                if (brothers[j].getRank() > brothers[j + 1].getRank()) {
                    Calabash b = brothers[j];
                    brothers[j] = brothers[j + 1];
                    brothers[j + 1] = b;
                }
            }
        }
    }
}
