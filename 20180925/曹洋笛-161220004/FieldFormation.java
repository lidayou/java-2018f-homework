import java.util.Random;

// 定义枚举类型
enum Guys {
    ST1("老大",'A'), ND2("老二",'B'), RD3("老三",'C'),
    TH4("老四",'D'), TH5("老五",'E'), TH6("老六",'F'), TH7("老七",'G');
    public String rank;
    public char symbol;
    private Guys(String rank, char symbol) { // 构造方法
        this.rank = rank;
        this.symbol = symbol;
    }
}
// 以下，坐标原点均在左上角，指向正下和正右
// 定义葫芦娃阵型
class brotherFormation {
    private int[] posX, posY; // 7个位置坐标
    private int cheerX, cheerY; // 加油助威位置
    public brotherFormation(int x, int y) {
        posX = new int[7];
        posY = new int[7];
        for (int i = 0; i < 7; i++) {
            posX[i] = x;
            posY[i] = y + i - 3;
        }
    }
    private void oldCheer() { // 老爷爷助威
        if ('@' == FieldFormation.findField(cheerX, cheerY))
            FieldFormation.setField(cheerX, cheerY, ' ');
        Random randArray = new Random(); // 生成随机数组
        // 老爷爷的位置为，参考随机葫芦娃的位置偏移随机距离(<=2)
        int ref = randArray.nextInt(7) % 7; // posX/posY[0 ~ 6]
        int dx, dy;
        while (true) { // 直到找到合适位置
            dx = randArray.nextInt(5) % 5 - 2; // -2 ~ 2
            dy = randArray.nextInt(5) % 5 - 2; // -2 ~ 2
            if (' ' == FieldFormation.findField(posX[ref] + dx, posY[ref] + dy))
                break;
        }
        cheerX = posX[ref] + dx;
        cheerY = posY[ref] + dy;
        FieldFormation.setField(cheerX, cheerY, '@');
    }
    public void inField() { // 将阵型放入场地
        for (Guys g : Guys.values()) {
            int i = g.compareTo(Guys.ST1);
            FieldFormation.setField(posX[i], posY[i], g.symbol);
        }
        oldCheer();
    }
    public void delFormation() { // 取消阵型
        for (int i = 0; i < 7; i++)
            FieldFormation.setField(posX[i], posY[i], ' ');
        FieldFormation.setField(cheerX, cheerY, ' ');
    }
    public void movFormation(int dx, int dy) { // 移动阵型
        for (int i = 0; i < 7; i++) {
            FieldFormation.setField(posX[i], posY[i], ' ');
            posX[i] += dx;
            posY[i] += dy;
        }
        inField();
    }
}
// 定义妖怪阵类
class monsterFormation {
    protected int lackeyNum; // 小喽啰人数
    protected int[] lackeyX, lackeyY; // 小喽啰+蝎子精坐标
    private int cheerX, cheerY; // 加油助威位置
    private void snakeCheer() { // 蛇精助威
        if ('$' == FieldFormation.findField(cheerX, cheerY))
            FieldFormation.setField(cheerX, cheerY, ' ');
        Random randArray = new Random(); // 生成随机数组
        // 蛇精的位置为，参考随机人员的位置偏移随机距离(<=2)
        int num = lackeyNum + 1;
        int ref = randArray.nextInt(num) % num; // lackeyX/lackeyY[0 ~ lackeyNum]
        int dx, dy;
        while (true) { // 直到找到合适位置
            dx = randArray.nextInt(5) % 5 - 2; // -2 ~ 2
            dy = randArray.nextInt(5) % 5 - 2; // -2 ~ 2
            if (' ' == FieldFormation.findField(lackeyX[ref] + dx, lackeyY[ref] + dy))
                break;
        }
        cheerX = lackeyX[ref] + dx;
        cheerY = lackeyY[ref] + dy;
        FieldFormation.setField(cheerX, cheerY, '$');
    }
    public void inField() { // 将阵型放入场地
        for (int i = 0; i < lackeyNum; i++)
            FieldFormation.setField(lackeyX[i], lackeyY[i], 'o');
        FieldFormation.setField(lackeyX[lackeyNum], lackeyY[lackeyNum], '&');
        snakeCheer();
    }
    public void delFormation() { // 取消阵型
        for (int i = 0; i <= lackeyNum; i++)
            FieldFormation.setField(lackeyX[i], lackeyY[i], ' ');
        FieldFormation.setField(cheerX, cheerY, ' ');
    }
    public void movFormation(int dx, int dy) { // 移动阵型
        for (int i = 0; i <= lackeyNum; i++) {
            FieldFormation.setField(lackeyX[i], lackeyY[i], ' ');
            lackeyX[i] += dx;
            lackeyY[i] += dy;
        }
        inField();
    }
}
// 鹤翼阵
class vFormation extends monsterFormation {
    public vFormation(int x, int y) { // 在子类的构造函数中显示的调用父类的构造函数
        super();
        lackeyNum = 6;
        lackeyX = new int[lackeyNum + 1];
        lackeyY = new int[lackeyNum + 1];
        lackeyX[0] = x - 3; lackeyY[0] = y - 3;
        lackeyX[1] = x - 2; lackeyY[1] = y - 2;
        lackeyX[2] = x - 1; lackeyY[2] = y - 1;
        lackeyX[3] = x + 1; lackeyY[3] = y - 1;
        lackeyX[4] = x + 2; lackeyY[4] = y - 2;
        lackeyX[5] = x + 3; lackeyY[5] = y - 3;
        lackeyX[6] = x; lackeyY[6] = y; // 蝎子精
    }
}
// 雁行阵
class iFormation extends monsterFormation {
    public iFormation(int x, int y) { // 在子类的构造函数中显示的调用父类的构造函数
        super();
        lackeyNum = 4;
        lackeyX = new int[lackeyNum + 1];
        lackeyY = new int[lackeyNum + 1];
        lackeyX[0] = x - 2; lackeyY[0] = y + 2;
        lackeyX[1] = x - 1; lackeyY[1] = y + 1;
        lackeyX[2] = x + 1; lackeyY[2] = y - 1;
        lackeyX[3] = x + 2; lackeyY[3] = y - 2;
        lackeyX[4] = x; lackeyY[4] = y; // 蝎子精
    }
}
// 冲轭阵
class llFormation extends monsterFormation {
    public llFormation(int x, int y) { // 在子类的构造函数中显示的调用父类的构造函数
        super();
        lackeyNum = 5;
        lackeyX = new int[lackeyNum + 1];
        lackeyY = new int[lackeyNum + 1];
        lackeyX[0] = x; lackeyY[0] = y - 2;
        lackeyX[1] = x; lackeyY[1] = y + 2;
        lackeyX[2] = x + 1; lackeyY[2] = y - 3;
        lackeyX[3] = x + 1; lackeyY[3] = y - 1;
        lackeyX[4] = x + 1; lackeyY[4] = y + 1;
        lackeyX[5] = x; lackeyY[5] = y; // 蝎子精
    }
}
// 鱼鳞阵
class xFormation extends monsterFormation {
    public xFormation(int x, int y) { // 在子类的构造函数中显示的调用父类的构造函数
        super();
        lackeyNum = 9;
        lackeyX = new int[lackeyNum + 1];
        lackeyY = new int[lackeyNum + 1];
        lackeyX[0] = x; lackeyY[0] = y - 2;
        lackeyX[1] = x + 1; lackeyY[1] = y - 1;
        lackeyX[2] = x + 2; lackeyY[2] = y;
        lackeyX[3] = x + 3; lackeyY[3] = y + 1;
        lackeyX[4] = x + 1; lackeyY[4] = y + 1;
        lackeyX[5] = x - 1; lackeyY[5] = y + 1;
        lackeyX[6] = x - 3; lackeyY[6] = y + 1;
        lackeyX[7] = x - 2; lackeyY[7] = y;
        lackeyX[8] = x; lackeyY[8] = y + 2;
        lackeyX[9] = x; lackeyY[9] = y; // 蝎子精
    }
}
// 方円阵
class oFormation extends monsterFormation {
    public oFormation(int x, int y) { // 在子类的构造函数中显示的调用父类的构造函数
        super();
        lackeyNum = 7;
        lackeyX = new int[lackeyNum + 1];
        lackeyY = new int[lackeyNum + 1];
        lackeyX[0] = x + 1; lackeyY[0] = y - 1;
        lackeyX[1] = x + 1; lackeyY[1] = y + 1;
        lackeyX[2] = x + 2; lackeyY[2] = y - 2;
        lackeyX[3] = x + 2; lackeyY[3] = y + 2;
        lackeyX[4] = x + 3; lackeyY[4] = y - 1;
        lackeyX[5] = x + 3; lackeyY[5] = y + 1;
        lackeyX[6] = x + 4; lackeyY[6] = y;
        lackeyX[7] = x; lackeyY[7] = y; // 蝎子精
    }
}
// 偃月阵
class cFormation extends monsterFormation {
    public cFormation(int x, int y) { // 在子类的构造函数中显示的调用父类的构造函数
        super();
        lackeyNum = 18;
        lackeyX = new int[lackeyNum + 1];
        lackeyY = new int[lackeyNum + 1];
        lackeyX[0] = x - 1; lackeyY[0] = y - 1;
        lackeyX[1] = x - 1; lackeyY[1] = y;
        lackeyX[2] = x - 1; lackeyY[2] = y + 1;
        lackeyX[3] = x; lackeyY[3] = y - 1;
        lackeyX[4] = x; lackeyY[4] = y + 1;
        lackeyX[5] = x + 1; lackeyY[5] = y - 2;
        lackeyX[6] = x + 1; lackeyY[6] = y - 1;
        lackeyX[7] = x + 1; lackeyY[7] = y;
        lackeyX[8] = x + 1; lackeyY[8] = y + 1;
        lackeyX[9] = x + 1; lackeyY[9] = y + 2;
        lackeyX[10] = x + 2; lackeyY[10] = y - 3;
        lackeyX[11] = x + 2; lackeyY[11] = y - 2;
        lackeyX[12] = x + 2; lackeyY[12] = y + 2;
        lackeyX[13] = x + 2; lackeyY[13] = y + 3;
        lackeyX[14] = x + 3; lackeyY[14] = y - 3;
        lackeyX[15] = x + 3; lackeyY[15] = y + 3;
        lackeyX[16] = x + 4; lackeyY[16] = y - 4;
        lackeyX[17] = x + 4; lackeyY[17] = y + 4;
        lackeyX[18] = x; lackeyY[18] = y; // 蝎子精
    }
}
// 锋矢阵
class mFormation extends monsterFormation {
    public mFormation(int x, int y) { // 在子类的构造函数中显示的调用父类的构造函数
        super();
        lackeyNum = 11;
        lackeyX = new int[lackeyNum + 1];
        lackeyY = new int[lackeyNum + 1];
        lackeyX[0] = x - 2; lackeyY[0] = y - 1;
        lackeyX[1] = x - 2; lackeyY[1] = y;
        lackeyX[2] = x - 2; lackeyY[2] = y + 1;
        lackeyX[3] = x - 1; lackeyY[3] = y - 2;
        lackeyX[4] = x - 1; lackeyY[4] = y;
        lackeyX[5] = x - 1; lackeyY[5] = y + 2;
        lackeyX[6] = x; lackeyY[6] = y - 3;
        lackeyX[7] = x; lackeyY[7] = y + 3;
        lackeyX[8] = x + 1; lackeyY[8] = y;
        lackeyX[9] = x + 2; lackeyY[9] = y;
        lackeyX[10] = x + 3; lackeyY[10] = y;
        lackeyX[11] = x; lackeyY[11] = y; // 蝎子精
    }
}

// 实现
public class FieldFormation {
    // 定义场地
    private static int fieldLen; // 场地（正方）边长
    private static char[][] field; // 场地
    static { // 静态变量初始化
        fieldLen = 15;
        field = new char[fieldLen][fieldLen];
        initField();
    }
    public static void initField() {
        for (int i = 0; i < fieldLen; i++) {
            for (int j = 0; j < fieldLen; j++)
                field[i][j] = ' ';
        }
    }
    public static char findField(int x, int y) { // 取坐标(x,y)的值
        if ((x >= 0) && (x < fieldLen) && (y >= 0) && (y < fieldLen))
            return field[x][y];
        else return '-';
    }
    public static void setField(int x, int y, char c) { // 在坐标(x,y)放置一个人物
        if ((x >= 0) && (x < fieldLen) && (y >= 0) && (y < fieldLen))
            field[x][y] = c;
    }
    public static void printField() {
        for (int j = 0; j < fieldLen; j++) {
            for (int i = 0; i < fieldLen; i++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        System.out.println("妖怪们在蝎子精&的带领下排出了鹤翼阵，葫芦娃ABCDEFG排出了长蛇阵");
        System.out.println("老爷爷于@处为葫芦娃助威，蛇精在$处为妖怪们加油");
        brotherFormation broForm = new brotherFormation(3, 7);
        broForm.inField();
        vFormation vForm = new vFormation(10, 7);
        vForm.inField();
        printField();
        vForm.delFormation();
        System.out.println("妖怪们换成了雁行阵，葫芦娃岿然不动");
        iFormation iForm = new iFormation(10, 7);
        iForm.inField();
        printField();
        iForm.delFormation();
        System.out.println("妖怪们换成了冲轭阵，葫芦娃岿然不动");
        llFormation llForm = new llFormation(10, 7);
        llForm.inField();
        printField();
        llForm.delFormation();
        System.out.println("妖怪们换成了鱼鳞阵，葫芦娃岿然不动");
        xFormation xForm = new xFormation(10, 7);
        xForm.inField();
        printField();
        xForm.delFormation();
        System.out.println("妖怪们换成了方円阵，葫芦娃岿然不动");
        oFormation oForm = new oFormation(10, 7);
        oForm.inField();
        printField();
        oForm.delFormation();
        System.out.println("妖怪们换成了偃月阵，葫芦娃岿然不动");
        cFormation cForm = new cFormation(10, 7);
        cForm.inField();
        printField();
        cForm.delFormation();
        System.out.println("妖怪们换成了锋矢阵，葫芦娃岿然不动");
        mFormation mForm = new mFormation(10, 7);
        mForm.inField();
        printField();
        System.out.println("妖怪们向左发动冲击，葫芦娃向右迎战");
        mForm.movFormation(-3, 0);
        broForm.movFormation(1, 0);
        printField();
        System.out.println("妖怪们退却了，葫芦娃乘胜追击");
        mForm.movFormation(2, 0);
        broForm.movFormation(1, 0);
        printField();
    }
}