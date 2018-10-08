public class Followers {

    static int count = 0;
    private int x;
    private int y;
    private char symbol;
    Followers(){
        x = 0;
        y = 0;
        symbol = '*';
    }
    Followers(int i, int j) {
        x = i;
        y = j;
        symbol = '*';
    }
    public void StandToField() {
        Calabash.battlefield[x][y] = symbol;
    }
    public int GetX() {
        return x;
    }
    public int GetY() {
        return y;
    }
}
