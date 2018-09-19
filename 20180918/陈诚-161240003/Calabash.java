package njucs.java2018;

enum COLOR {
    RED, ORA, YEL, GRE, CYA, BLU, PUR,
}

class Brother {
    int rank;
    COLOR color;
    String name;
    Brother(int rank, COLOR color, String name) {
        this.rank = rank;
        this.color = color;
        this.name = name;
    }
}

public class Calabash {
    public static void BubbleSort(Brother[] brothers) {
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

    public static void BinaryInsertSort(Brother[] brothers) {
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

    public static void main(String []args) {
        Brother[] brothers = {
                new Brother(3, COLOR.YEL, "老三"),
                new Brother(1, COLOR.RED, "老大"),
                new Brother(5, COLOR.CYA, "老五"),
                new Brother(2, COLOR.ORA, "老二"),
                new Brother(7, COLOR.PUR, "老七"),
                new Brother(4, COLOR.GRE, "老四"),
                new Brother(6, COLOR.BLU, "老六")
        };

        System.out.println("Before BubbleSort.");
        for(Brother b : brothers) {
            System.out.println(b.name);
        }
        System.out.println("During BubbleSort.");
        BubbleSort(brothers);
        System.out.println("After BubbleSort.");
        for(Brother b : brothers) {
            System.out.println(b.name);
        }

        Brother[] new_brothers = {
                new Brother(2, COLOR.ORA, "老二"),
                new Brother(7, COLOR.PUR, "老七"),
                new Brother(1, COLOR.RED, "老大"),
                new Brother(3, COLOR.YEL, "老三"),
                new Brother(5, COLOR.CYA, "老五"),
                new Brother(4, COLOR.GRE, "老四"),
                new Brother(6, COLOR.BLU, "老六")
        };

        System.out.println("Before BinaryInsertSort.");
        for(Brother b : new_brothers) {
            System.out.println(b.color.toString());
        }
        System.out.println("During BinaryInsertSort.");
        BinaryInsertSort(new_brothers);
        System.out.println("After BinaryInsertSort.");
        for(Brother b : new_brothers) {
            System.out.println(b.color.toString());
        }
    }
}
