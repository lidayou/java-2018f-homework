import java.util.Random;

enum Formation {
    OVEREDGE("鹤翼",1), ECHELON("雁行",2), YOKE("冲轭",3), HYDRA("长蛇",4),
    SCALE("鱼鳞",5), SQUARE("方円",6), HOOKEDSPEAR("偃月",7), ARROW("锋矢",8);

    String Cname;
    boolean[][] form;
    int num;
    Formation(String Cname, int n) {
        this.Cname = Cname;
        form = new boolean[11][10];
        switch (n) {
            case 1:     //鹤翼
                num = 7;
                for (int i = 3; i < 7; i++){
                    form[i][i-1] = true;
                }
                for (int i = 3; i < 6; i++){
                    form[i][11-i] = true;
                }
                break;
            case 2:     //雁行
                num = 5;
                for (int i = 3; i < 3+5; i++) {
                    form[i][10-i] = true;
                }
                break;
            case 3:     //冲轭
                num = 6;
                for (int i = 3; i < 8; i += 2) {
                    form[i][3] = true;
                }
                for (int i = 2; i < 7; i += 2){
                    form[i][4] = true;
                }
                break;
            case 4:     //长蛇
                num = 7;
                for  (int i = 0; i < 7; i++) {
                    form[i+2][5] = true;
                }
                break;
            case 5:     //鱼鳞
                num = 13;
                form[6][5] = true;
                form[2][5] = true;
                form[3][6] = true;
                for (int i = 3; i < 9; i++){
                    form[5][i] = true;
                }
                for (int i = 2; i < 8; i++) {
                    form[4][i] = true;
                }
                break;
            case 6:     //方円
                num = 8;
                for (int i = 3; i < 6; i++) {
                    form[i][8-i] = true;
                }
                for (int i = 3; i < 6; i++) {
                    form[i][i+2] = true;
                }
                form[6][4] = true;
                form[6][6] = true;
                form[6][5] = true;
                break;
            case 7:     //偃月
                num = 19;
                for (int i = 1; i < 7; i++) {
                    form[i][8-i] = true;
                }
                for (int i = 2; i < 6; i++) {
                    form[i][7-i] = true;
                }
                for (int i = 6; i < 9; i++) {
                    form[i][i-3] = true;
                }
                for (int i = 6; i < 10; i++) {
                    form[i][i-2] = true;
                }
                form[4][2] = true;
                form[5][4] = true;
                break;
            case 8:     //锋矢
                num = 12;
                for (int i = 2; i < 8; i++){
                    form[i][5] = true;
                }
                for (int i = 3; i < 6; i++) {
                    form[i][7-i] = true;
                }
                for (int i = 3; i < 6; i++) {
                    form[i][i+3] = true;
                }
                break;
        }
    }
}

class Brick {
    char sign;
    Brick() {
        sign = '_';
    }
}

class BattleField{
    int row, col;
    Brick[][] bricks;

    BattleField(int row, int col) {
        this.row = row;
        this.col = col;
        bricks = new Brick[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                bricks[i][j] = new Brick();
            }
        }
    }

    void ShowField() {
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col-1; c++){
                System.out.print(bricks[r][c].sign + " ");
            }
            System.out.println(bricks[r][col-1].sign);
        }
    }
}

public class Battle {
    private static final int N = 20;
    static private BattleField field;

    public static void main(String[] args) {
        field = new BattleField(N,N);
        CBQueue cbqueue = new CBQueue();
        VillainQueue vlQueue = new VillainQueue(20);
        Creature grandpa = new Creature("爷爷", Factions.JUSTICE, 'T');
        Creature snake = new Creature("蛇精", Factions.EVIL, 'S');

        Sorter sorter = new Sorter();
        System.out.println("CalabashBro queuing...");
        cbqueue.randomQueue();
        System.out.println("Before sorting by name:");
        cbqueue.countOffAcName();
        sorter.SortByName(cbqueue);
        System.out.println("After sorting by name:");
        cbqueue.countOffAcName();
        System.out.println();
        cbqueue.JumpOntoField(field, Formation.HYDRA);

        System.out.println("符号说明：");
        System.out.println("葫芦娃：1-7，爷爷：T（拐杖嘛）");
        System.out.println("小喽啰：v（一把钢叉），蝎子精：w（两把钢叉），蛇精：S（魔鬼身材）");
        System.out.println();

        vlQueue.JumpOntoField(field, Formation.HOOKEDSPEAR);
        grandpa.stepOn(field, 15, 4);
        snake.stepOn(field, 15, 16);
        System.out.println("长蛇阵 vs 偃月阵！ 激战！（最后一句好中二……");
        field.ShowField();
        System.out.println();

        vlQueue.leaveField(field);
        vlQueue.JumpOntoField(field, Formation.ARROW);
        System.out.println("长蛇阵 vs 锋矢阵！ 激战！（最后一句真的中二……");
        field.ShowField();
    }
}

enum Factions {
    EVIL, JUSTICE
}

class Creature {
    String CName;
    private Factions factions;
    private int placeR, placeC;
    char sign;

    Creature(String CName, Factions factions, char sign) {
        this.CName = CName;
        this.factions = factions;
        placeR = -1;
        placeC = -1;
        this.sign = sign;
    }

    void stepOn(BattleField field, int r, int c) {
        placeC = c;
        placeR = r;
        field.bricks[r][c].sign = sign;
    }

    void leave(BattleField field){
        field.bricks[placeR][placeC].sign = '_';
        placeR = -1;
        placeC = -1;
    }
}

class VillainQueue {
    Creature[] vlQueue;
    int numTotal, numOnField;

    VillainQueue(int n) {
        vlQueue = new Creature[n];
        vlQueue[0] = new Creature("蝎子精", Factions.EVIL, 'w');
        for (int i = 1; i < n; i++) {
            vlQueue[i] = new Creature("小喽啰", Factions.EVIL, 'v');
        }
        numTotal = n;
    }

    void JumpOntoField(BattleField field, Formation form){
        int idx = 0;
        for (int r = 4; r < 15; r++) {
            for (int c = 0; c < 10; c++) {
                if (form.form[r-4][c]){
                    vlQueue[idx].stepOn(field, r, c+10);
                    idx++;
                }
            }
        }
        numOnField = idx;
    }

    void leaveField(BattleField field) {
        for (int i = 0; i < numOnField; i++) {
            vlQueue[i].leave(field);
        }
        numOnField = 0;
    }
}

enum Color {
    RED("红色"), ORANGE("橙色"),YELLOW("黄色"),
    GREEN("绿色"), CYAN("青色"), BLUE("蓝色"), VIOLET("紫色");

    String CName;
    Color(String CName) {
        this.CName = CName;
    }
}

class CalabashBro extends Creature {
    private Color color;
    private int placeInQue;
    private int seq;

    CalabashBro(String CName, Factions factions, Color color, int seq, int placeInQue, char sign) {
        super(CName, factions, sign);
        this.color = color;
        this.seq = seq;
        this.placeInQue = placeInQue;
    }

    int getSeq() {
        return seq;
    }

    String getName() {
        return CName;
    }

    Color getColor() {
        return color;
    }

    void changePlaceInQue(int idx, boolean report) {
        int oldPlace = placeInQue;
        placeInQue = idx;
        if (report){
            System.out.println(CName + ": " + oldPlace + " -> " + placeInQue);
        }
    }
}

class CBQueue {
    CalabashBro[] broQueue;

    CBQueue() {
        broQueue = new CalabashBro[7];
        broQueue[0] = new CalabashBro("老大", Factions.JUSTICE, Color.RED, 1, 0, '1');
        broQueue[1] = new CalabashBro("老二", Factions.JUSTICE, Color.ORANGE, 2, 1, '2');
        broQueue[2] = new CalabashBro("老三", Factions.JUSTICE, Color.YELLOW, 3, 2, '3');
        broQueue[3] = new CalabashBro("老四", Factions.JUSTICE, Color.GREEN, 4, 3, '4');
        broQueue[4] = new CalabashBro("老五", Factions.JUSTICE, Color.CYAN, 5, 4, '5');
        broQueue[5] = new CalabashBro("老六", Factions.JUSTICE, Color.BLUE, 6, 5, '6');
        broQueue[6] = new CalabashBro("老七", Factions.JUSTICE, Color.VIOLET, 7, 6, '7');

    }

    void randomQueue() {
        // Knuth Shuffle
        Random rd = new Random();
        for (int i = 6; i > 0; i--) {
            int idx = rd.nextInt(i+1);
            CalabashBro temp = broQueue[idx];
            broQueue[idx] = broQueue[i];
            broQueue[idx].changePlaceInQue(idx, false); // here... changePlace ... need to improve...->Object Oriented
            broQueue[i] = temp;
            broQueue[i].changePlaceInQue(i, false);
        }
    }

    void countOffAcName() {
        for (int i = 0; i < 6; i++) {
            System.out.print(broQueue[i].getName()+" ");
        }
        System.out.println(broQueue[6].getName());
    }

    void countOffAcColor() {
        for (int i = 0; i < 6; i++) {
            System.out.print(broQueue[i].getColor().CName+" ");
        }
        System.out.println(broQueue[6].getColor().CName);
    }

    void JumpOntoField(BattleField field, Formation form){
        int idx = 0;
        for (int r = 4; r < 15; r++) {
            for (int c = 0; c < 10; c++) {
                if (form.form[r-4][9-c]){
                    broQueue[idx].stepOn(field, r, c);
                    idx++;
                }
            }
        }
    }
}

abstract class SortAlg {
    public abstract void sort(CalabashBro array[], int n);
}

class BubbleSort extends SortAlg {
    public void sort(CalabashBro array[], int n){
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].getSeq() > array[j+1].getSeq()) {
                    CalabashBro temp = array[j];
                    array[j] = array[j+1];
                    array[j].changePlaceInQue(j, true); // here... changePlace ... need to improve...->Object Oriented
                    array[j+1] = temp;
                    array[j+1].changePlaceInQue(j+1, true);
                }
            }
        }
    }
}

class BiSort extends SortAlg {
    public void sort(CalabashBro array[], int n){
        for (int i = 0; i < n; i++) {
            CalabashBro current = array[i];
            int hd = 0, tl = i-1, mid = 0;
            while (hd <= tl) {
                mid = (hd + tl) / 2;
                if (current.getColor().ordinal() < array[mid].getColor().ordinal())     //mid!!!not hd!!!
                    tl = mid - 1;
                else
                    hd = mid + 1;
            }
            for (int j = i; j > hd; j--){
                array[j] = array[j-1];
                array[j].changePlaceInQue(j, true);
            }
            if (hd != i) {
                array[hd] = current;
                array[hd].changePlaceInQue(hd, true);
            }
        }
    }
}

class Sorter {
    private SortAlg alg;

    void SortByName(CBQueue cbq) {
        alg = new BubbleSort();
        alg.sort(cbq.broQueue, 7);
    }

    void SortByColor(CBQueue cbq) {
        alg = new BiSort();
        alg.sort(cbq.broQueue, 7);
    }
}
