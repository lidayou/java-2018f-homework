import java.util.Random;

public class Brothers {
    private Brother[] brothers;
    Brothers(){
        brothers = new Brother[]{
                        new Brother(1),
                        new Brother(2),
                        new Brother(3),
                        new Brother(4),
                        new Brother(5),
                        new Brother(6),
                        new Brother(7)};
    }

    public void randStand(){
        Random random = new Random();
        for(int i=0;i<7;i++){
            int p = random.nextInt(i+1);
            Brother tmp = brothers[i];
            brothers[i] = brothers[p];
            brothers[p] = tmp;
        }
    }

    public void speakName(){
        for(int i = 0;i<7;i++){
            System.out.print(brothers[i].getName());
            System.out.print(" ");
        }
        System.out.println();
    }

    public void speakColor() {
        for(int i = 0;i<7;i++){
            System.out.print(brothers[i].getColor());
            System.out.print(" ");
        }
        System.out.println();
    }

    public boolean compareByName(int id1, int id2){
        if(brothers[id1].getEnumName().compareTo(brothers[id2].getEnumName()) > 0)
            return true;
        else
            return false;
    }

    public void lineByName(){//使用了冒泡排序
        for(int i = 0;i<7;i++){
            for(int j = 0;j<7-i-1;j++){
                if (compareByName(j,j+1)){
                    System.out.println(brothers[j].getName()+":"+(j+1)+"->"+(j+2));
                    System.out.println(brothers[j+1].getName()+":"+(j+2)+"->"+(j+1));
                    Brother tmp = brothers[j];
                    brothers[j] = brothers[j+1];
                    brothers[j+1] = tmp;
                }
            }
        }
    }

   public void lineByColor() {//使用二分排序
        Brother temp;
        int low,high,mid;
        for(int i = 1;i<7;i++){
            temp = brothers[i];
            String temp_name = brothers[i].getName();
            System.out.println(brothers[i].getName()+":"+(i+1)+"->"+"temp");
            low = 0;
            high = i-1;
            while(low<=high){
                mid = (low+high)/2;
                if(brothers[mid].getEnumColor().compareTo(temp.getEnumColor()) > 0){
                    high = mid-1;
                }
                else {
                    low = mid + 1;
                }
            }
            for(int j = i-1;j>high;j--){
                System.out.println(brothers[j].getName()+":"+(j+1)+"->"+(j+2));
                brothers[j+1] = brothers[j];
            }
            System.out.println(temp_name+":"+"temp"+"->"+(high+2));
            brothers[high+1] = temp;
        }
   }
}
