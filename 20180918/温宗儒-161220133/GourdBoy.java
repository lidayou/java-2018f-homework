import java.util.Scanner;

public class GourdBoy {
    private Attribute attribute;

    //constructor
    private GourdBoy(Attribute attribute){ this.attribute = attribute; }

    private static void bubbleSort(GourdBoy[] gourdBoys){
        for(int i=0; i<7; i++){
            for(int j=i+1; j<7; j++){
                if(gourdBoys[i].attribute.getRank() > gourdBoys[j].attribute.getRank()){
                    System.out.println(gourdBoys[i].attribute.getName()+":"+(i+1)+"->"+(j+1));
                    System.out.println(gourdBoys[j].attribute.getName()+":"+(j+1)+"->"+(i+1));
                    GourdBoy temp = gourdBoys[i];
                    gourdBoys[i] = gourdBoys[j];
                    gourdBoys[j] = temp;

                }
            }
        }

        for(GourdBoy cycle : gourdBoys){
            System.out.print(cycle.attribute.getName() + "\t");
        }
        System.out.println();
    }

    private static void binaryInsertSort(GourdBoy[] gourdBoys){
        int start,end,mid,j;
        GourdBoy temp;

        for(int i=1;i<7;i++){
            start=0;
            end = i-1;
            temp = gourdBoys[i];

            while (start<=end){
                mid = (start + end)/2;
                if(temp.attribute.getRank() < gourdBoys[mid].attribute.getRank()){
                    end = mid-1;
                }else {
                    start = mid + 1;
                }
            }

            for(j = i-1;j>=start;j--){
                System.out.println(gourdBoys[j].attribute.getName()+":"+(j+1)+"->"+(j+2));
                gourdBoys[j+1] = gourdBoys[j];
            }
            System.out.println(temp.attribute.getName()+":"+(i+1)+"->"+(start+1));
            gourdBoys[start] = temp;
        }

        for(GourdBoy cycle : gourdBoys){
            System.out.print(cycle.attribute.getColor() + "\t");
        }
        System.out.println();

    }


    public static void main(String[] args){
        GourdBoy[] gourdBoys = new GourdBoy[7];
        Scanner scanner = new Scanner(System.in);
        System.out.println("请依次输入葫芦七兄弟的随意排队(用1代表大娃，2代表二娃...):");
        int[] queuedArray = new int[7];
        for(int i=0; i<7; i++){ queuedArray[i] = scanner.nextInt(); }
        for(int i=0; i<7; i++){
            Attribute newAttribute = Attribute.values()[queuedArray[i]-1];
            gourdBoys[i] = new GourdBoy(newAttribute);
        }
        bubbleSort(gourdBoys);

        System.out.println("请重新输入葫芦七兄弟的随意排队(用1代表大娃，2代表二娃...):");
        for(int i=0; i<7; i++){ queuedArray[i] = scanner.nextInt(); }
        for(int i=0; i<7; i++){
            Attribute newAttribute = Attribute.values()[queuedArray[i]-1];
            gourdBoys[i] = new GourdBoy(newAttribute);
        }
        binaryInsertSort(gourdBoys);

    }
}
