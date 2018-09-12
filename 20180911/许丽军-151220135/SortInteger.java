public class SortInteger {

    public static void main(String[] args){

        //a given Integer array
        int[] array = {3,1,4,2,5,7,8,6,0,6};

        System.out.println("unsorted:");
        print(array);
        sort(array);
        System.out.println("sorted:");
        print(array);

    }

    static void sort(int[] array){
        int n = array.length;
        // bubble sort algorithm
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(array[i] < array[j]){
                    int t  = array[i];
                    array[i] = array[j];
                    array[j] = t;
                }
            }
        }
    }

    static void print(int[] array){
        for(int a:array) {
            System.out.print(a);
            System.out.print("\t");
        }
        System.out.println();
    }
}
