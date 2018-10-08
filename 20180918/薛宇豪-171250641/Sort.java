import java.util.Random;

public class Sort{
    public static void main(String[] args){
        calabashBrothers[] queue=new calabashBrothers[7];
        RandomSort(queue);
        BubbleSort(queue);
        RandomSort(queue);
        BinarySort(queue);
    }

    private static void RandomSort(calabashBrothers[] queue) {
        Random random = new Random();
        int[] tag={0,0,0,0,0,0,0};
        int size=queue.length;
        int count=-1;
        while (count<6){
            int num=random.nextInt(size);
            if(tag[num]==0){
                count++;
                tag[num]=1;
                switch (num){
                    case 0:queue[count]=calabashBrothers.老大;break;
                    case 1:queue[count]=calabashBrothers.老二;break;
                    case 2:queue[count]=calabashBrothers.老三;break;
                    case 3:queue[count]=calabashBrothers.老四;break;
                    case 4:queue[count]=calabashBrothers.老五;break;
                    case 5:queue[count]=calabashBrothers.老六;break;
                    case 6:queue[count]=calabashBrothers.老七;break;
                }
            }
        }
        System.out.print("随机站队后的位置为：");
        for (int i=0;i<size-1;i++){
            System.out.print(queue[i].toString()+"、");
        }
        System.out.println(queue[size-1].toString());
    }

    private static void BubbleSort(calabashBrothers[] queue) {
        for(int i=0;i<queue.length-1;i++){
            for(int j=i+1;j<queue.length;j++){
                if(queue[i].compareTo(queue[j])>0){
                    int start=j+1;
                    int end=i+1;
                    System.out.println(queue[j].toString()+": "+start+"->"+end);

                    calabashBrothers temp=queue[i];
                    queue[i]=queue[j];
                    queue[j]=temp;
                }
            }
        }
        System.out.print("报数：");
        for (int i=0;i<queue.length-1;i++){
            System.out.print(queue[i].toString()+" ");
        }
        System.out.println(queue[queue.length-1].toString());
    }


    private static void BinarySort(calabashBrothers[] queue) {
        for(int i=1;i<queue.length;i++) {
            calabashBrothers temp=queue[i];
            int low=0;
            int high=i-1;
            while(low<=high){
                int mid=(low+high)/ 2;
                if(queue[mid].compareTo(temp)>0){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
            for(int j=i-1;j>high;j--) {
                int start=j+1;
                int end=j+2;
                System.out.println(queue[j].toString()+": "+start+"->"+end);

                queue[j+1]=queue[j];
            }
            queue[high+1]=temp;
        }
        System.out.print("报数：");
        for (int i=0;i<queue.length-1;i++){
            System.out.print(queue[i].getColor(queue[i])+" ");
        }
        System.out.println(queue[queue.length-1].getColor(queue[queue.length-1]));
    }
}