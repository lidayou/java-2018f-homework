public class integerSort {
    public static void main(String[] args) {
        int integerSort[] = new int[]{32,43,53,54,32,65,63,98,43,23};
        for(int i = 0; i < integerSort.length;i++){
            for(int j = i+1; j < integerSort.length; j++){
                if(integerSort[i] > integerSort[j]) {
                    int temp = integerSort[i];
                    integerSort[i] = integerSort[j];
                    integerSort[j] = temp;
                }
            }
        }
        for(int i = 0; i < integerSort.length;i++){
            System.out.print(integerSort[i]);
            System.out.print(' ');
        }
    }

}
