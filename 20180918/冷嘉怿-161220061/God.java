package ljy.Cucurbit;

public class God {
    private final int CB_NUM=7;
    private CucurbitBoy cbs[]=new CucurbitBoy[CB_NUM];
    private void swap(int cb1, int cb2)
    {
        CucurbitBoy tmp=cbs[cb1];
        cbs[cb1]=cbs[cb2];
        cbs[cb2]=tmp;
    }
    public static void main(String[] args){
        System.out.println("God is created");
        God god=null;
        try{
            god=new God();
        }catch (Exception e){
            e.printStackTrace();
            return;
        }
        god.BiSort();
        for(CucurbitBoy x:god.cbs)
            x.tellName();
    }
    God() throws Exception {
        for(int i=0;i<CB_NUM;i++)
            cbs[i]=new CucurbitBoy();
        this.swap(2,3);
        this.swap(2,4);
        this.swap(6,1);
    }
    protected void BiSort()
    {
        for(int i=1;i<CB_NUM;i++)
        {
            int left=0;
            int right=i-1;
            int mid=0;
            while(left<=right)
            {
                mid=(left+right)/2;
                if(cbs[mid].getID()<cbs[i].getID())
                    left=mid+1;
                else
                    right=mid-1;
            }
            int index=left;
            if(index!=i)
            {
                CucurbitBoy tmp=cbs[i];
                for(int j=i-1;j>=index;j--)
                    cbs[j+1]=cbs[j];
                cbs[index]=tmp;
            }
        }
    }
}
