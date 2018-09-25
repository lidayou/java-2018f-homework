/* XuXiang 161220153 2018/9/18 19:15 */

public class CalabashBros {
    private Calabash[] calabash = new Calabash[7];
    private String[] colorArray = new String[] {"黄色","蓝色","青色","橙色","紫色","红色","绿色"};
    private String[] nameArray = new String[] {"老三","老六","老五","老二","老七","老大","老四"};
    private int[] numberArray = new int[] {3,6,5,2,7,1,4};
    public CalabashBros(){
        for(int i=0;i<7;i++){
            calabash[i] = new Calabash();
        }
    }
    private void disorder(){
        for(int i=0;i<7;i++){
            calabash[i].setAttribute(numberArray[i],colorArray[i],nameArray[i],i+1);
        }
    }
    private void bubbleSort(){
        for(int i=6;i>0;i--) {
            for (int j = 6; j >= 7-i; j--) {
                if (calabash[j].getNumber() < calabash[j - 1].getNumber()) {
                    Calabash temp = calabash[j];
                    calabash[j] = calabash[j - 1];
                    calabash[j - 1] = temp;
                    calabash[j].changeOrder(j+1);
                    calabash[j - 1].changeOrder(j);
                }
            }
        }
    }
    private void tellName(){
        for(int i=0;i<7;i++){
            calabash[i].tellName();
        }
    }
    private void binarySort(){
        for(int i=1;i<7;i++){
            int left = 0, right = i-1;
            while(left<=right){
                int mid = (left+right)/2;
                if(calabash[i].getNumber()<calabash[mid].getNumber()){
                    right = mid-1;
                }
                else if(calabash[i].getNumber()>calabash[mid].getNumber()){
                    left = mid+1;
                }
            }
            Calabash temp = calabash[i];
            for(int j=i-1;j>right;j--){
                calabash[j+1] = calabash[j];
                calabash[j+1].changeOrder(j+2);
            }
            calabash[right+1] = temp;
            calabash[right+1].changeOrder(right+2);
        }
    }
    private void tellColor(){
        for(int i=0;i<7;i++){
            calabash[i].tellColor();
        }
    }
    public static void main(String arg[]){
        CalabashBros calabashBrothers = new CalabashBros();
        calabashBrothers.disorder();
        calabashBrothers.bubbleSort();
        calabashBrothers.tellName();
        calabashBrothers.disorder();
        calabashBrothers.binarySort();
        calabashBrothers.tellColor();
    }
}
