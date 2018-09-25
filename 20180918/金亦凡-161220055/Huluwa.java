import java.util.Random;

enum Color {
    RED(1, "老大", "红色"), ORANGE(2, "老二", "橙色"), YELLOW(3, "老三", "黄色"), GREEN(4, "老四", "绿色"), INDIGO(5, "老五", "青色"), BLUE(6, "老六", "蓝色"), PURPLE(7, "老七", "紫色");

    private int num;
    private String name;
    private String color;

    private Color(int num, String name, String color) {
        this.num = num;
        this.name = name;
        this.color = color;
    }

    public void NumberOff() {
        System.out.print(name);
    }

    public int getNum() {
        return num;
    }

    public void ColorOff() {
        System.out.print(color);
    }

    public void move(int i, int j) {
        System.out.println(name + "：" + i + "->" + j);
    }
}

public class Huluwa {
    private static Color[] Hs = Color.values();

    private static void swapHuluwa(Color[] Hs, int i, int j) {
        Color temp = Hs[i];
        Hs[i] = Hs[j];
        Hs[j] = temp;
    }

    private static void RandomArrange(Color[] Hs) {
        Random random = new Random();
        for(int i = 0; i < 7; i++) {
            int index = random.nextInt(7);
            swapHuluwa(Hs, index, i);
        }
    }

    private static void NumberOff() {
        for(int i = 0; i < 7; i++) {
            Hs[i].NumberOff();
            System.out.print(' ');
        }
        System.out.print('\n');
    }

    private static void ColorOff() {
        for(int i = 0; i < 7; i++) {
            Hs[i].ColorOff();
            System.out.print(' ');
        }
        System.out.print('\n');
    }

    public static void main(String[] argv) {
        System.out.println("七个葫芦娃随意站队，并报数：");
        RandomArrange(Hs);
        NumberOff();
        System.out.println("按排行冒泡排序：");
        for(int i = 5; i >=0; i--) {
            for(int j = i; j < 6; j++) {
                if(Hs[j].getNum() > Hs[j + 1].getNum()) {
                    Hs[j].move(j, j + 1);
                    Hs[j + 1].move(j + 1, j);
                    swapHuluwa(Hs, j, j + 1);
                }
            }
        }
        NumberOff();
        System.out.println("七个葫芦娃随意站队，并报颜色：");
        RandomArrange(Hs);
        ColorOff();
        System.out.println("按颜色二分排序：");
        for(int i = 1; i < 7; i++) {
            int start = 0;
            int end = i - 1;
            int middle = (start + end) / 2;
            while(end >= start) {
                if(Hs[i].getNum() > Hs[middle].getNum())
                    start = middle + 1;
                else
                    end = middle - 1;
                middle = (start + end) / 2;
            }
            Hs[i].move(i, start);
            Color temp = Hs[i];
            for(int j = i; j > start; j--) {
                Hs[j] = Hs[j - 1];
                Hs[j - 1].move(j - 1, j);
            }
            Hs[start] = temp;
        }
        ColorOff();
    }
}




