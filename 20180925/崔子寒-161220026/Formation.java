/*names of formations*/
enum FormationName {
    HEYI("鹤翼"),YANXING("雁行"),CHONGE("衝軛"),
    CHANGSHE("长蛇"), YULIN("鱼鳞"), FANG("方块"),
    YANYUE("偃月"), FENGSHI("锋矢");

    private String name;
    FormationName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class Formation {
    public final static Position[][] formation={
            {new Position(2,2),new Position(3,3),new Position(4,4), new Position(5,5),
                    new Position(5,6),new Position(4,7),new Position(3,8),new Position(2,9),},
            {new Position(2,9),new Position(3,8), new Position(4,7), new Position(5,6),
                    new Position(6,5),new Position(7,4),new Position(8,3),new Position(9,2),},
            {new Position(1,5),new Position(2,4),new Position(3,5), new Position(4,4),
                    new Position(5,5),new Position(6,4),new Position(7,5),new Position(8,4),},
            {new Position(1,5),new Position(2,5),new Position(3,5), new Position(4,5),
                    new Position(5,5),new Position(6,5),new Position(7,5),new Position(8,5),},
            {new Position(3,4),new Position(4,4),new Position(4,5), new Position(5,3),
                    new Position(5,4),new Position(5,5),new Position(5,6),new Position(6,4),},
            {new Position(3,4),new Position(4,3),new Position(4,5), new Position(5,2),
                    new Position(5,6),new Position(6,3),new Position(6,5),new Position(7,4),},
            {new Position(2,5),new Position(3,4),new Position(4,3), new Position(4,4),
                    new Position(5,3),new Position(5,4),new Position(6,4),new Position(7,5),},
            {new Position(4,3),new Position(3,4),new Position(2,5), new Position(3,6),
                    new Position(4,7),new Position(3,5),new Position(4,5),new Position(5,5),},

            };

    /*Formation Test*/
    /*
    public static void main(String[] args) {
        int map[][]=new int[10][10];
        for(int i=0; i< 10; i++) {
            for(int j=0;j<10;j++) {
                map[i][j]=0;
            }
        }

        for(int i=0;i<8;i++){
            map[formation[0][i].x][formation[0][i].y]=1;
        }
        for(int i=0; i< 10; i++) {
            for(int j=0;j<10;j++) {
                if(map[i][j]==1)
                    System.out.print("小怪");
                else
                    System.out.print("   ");
            }
            System.out.println();
        }
    }*/
}
