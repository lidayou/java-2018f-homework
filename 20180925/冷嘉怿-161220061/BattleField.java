package ljy.Cucurbit;

public class BattleField {
    public static int width=15;
    public static int height=15;
    public static char field[][]=new char[height][width];
    public static void clear()
    {
        for(int i=0;i<height;i++)
            for (int j = 0; j < width; j++)
                field[i][j]='_';
    }
    public static void print()
    {
        for(int i=0;i<height;i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(field[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}
