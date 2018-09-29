package njucs.java2018;
import java.util.Random;

enum COLOR {
    RED("红色"), ORA("橙色"), YEL("黄色"), GRE("绿色"), CYA("青色"), BLU("蓝色"), PUR("紫色");
    String color;
    COLOR(String color) {
        this.color = color;
    }
}

class Brother {
    int rank;
    COLOR color;
    String name;
    Brother(int rank) {
        this.rank = rank;
        switch(rank) {
            case 1:
                color = COLOR.RED;
                name = "老大";
                break;
            case 2:
                color = COLOR.ORA;
                name = "老二";
                break;
            case 3:
                color = COLOR.YEL;
                name = "老三";
                break;
            case 4:
                color = COLOR.GRE;
                name = "老四";
                break;
            case 5:
                color = COLOR.CYA;
                name = "老五";
                break;
            case 6:
                color = COLOR.BLU;
                name = "老六";
                break;
            case 7:
                color = COLOR.PUR;
                name = "老七";
                break;
            default:
                System.out.println("WRONG RANK");
                break;
        }
    }
}

public class Calabash {
    private static void BubbleSort(Brother[] brothers) {
        for(int i = 0; i < brothers.length - 1; i ++) {
            for (int j = 0; j < brothers.length - 1 - i; j++) {
                if (brothers[j].rank > brothers[j + 1].rank) {
                    System.out.printf("%s:%d -> %d\n", brothers[j].name, j, j + 1);
                    System.out.printf("%s:%d -> %d\n", brothers[j + 1].name, j + 1, j);
                    Brother temp = brothers[j];
                    brothers[j] = brothers[j + 1];
                    brothers[j + 1] = temp;
                }
            }
        }
    }

    private static void BinaryInsertSort(Brother[] brothers) {
        for(int i = 0; i < brothers.length; i ++) {
            Brother temp = brothers[i];
            int left = 0;
            int right = i - 1;
            while(left <= right) {
                int middle = (left + right) / 2;
                if(temp.color.ordinal() > brothers[middle].color.ordinal())
                    left = middle + 1;
                else
                    right = middle - 1;
            }
            for(int j = i - 1; j >= left; j --) {
                System.out.printf("%s:%d -> %d\n", brothers[j].name, j, j + 1);
                brothers[j + 1] = brothers[j];
            }
            if(left != i) {
                System.out.printf("%s:%d -> %d\n", temp.name, i, left);
                brothers[left] = temp;
            }
        }
    }

    private static void De_sort(Brother[] brothers) {
        Random rand = new Random();
        for(int i = 6; i > 0; i --) {
            int p = rand.nextInt(i);
            Brother tmp = brothers[i];
            brothers[i] = brothers[p];
            brothers[p] = tmp;
        }
    }

    public static void main(String []args) {
        Brother[] brothers = new Brother[7];
        for(int i = 1; i <= 7; i ++) {
            brothers[i - 1] = new Brother(i);
        }
        //冒泡排序
        De_sort(brothers);
        System.out.println("Before BubbleSort.");
        for(Brother b : brothers)
            System.out.println(b.name);
        System.out.println("During BubbleSort.");
        BubbleSort(brothers);
        System.out.println("After BubbleSort.");
        for(Brother b : brothers)
            System.out.println(b.name);

        System.out.println();

        //二分插入排序
        De_sort(brothers);
        System.out.println("Before BinaryInsertSort.");
        for(Brother b : brothers)
            System.out.println(b.color.color);
        System.out.println("During BinaryInsertSort.");
        BinaryInsertSort(brothers);
        System.out.println("After BinaryInsertSort.");
        for(Brother b : brothers)
            System.out.println(b.color.color);
    }
}