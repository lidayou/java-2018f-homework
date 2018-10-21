public class Scorpion {
    private int x;
    private int y;
    private char symbol;
    Scorpion(){
        x = 0;
        y = 0;
        symbol = '$';
    }
    Scorpion(int i, int j) {
        x = i;
        y = j;
        symbol = '$';
    }
    void SetPositon(int i, int j) {
        x = i;
        y = j;
    }
    int GetX(){
        return x;
    }
    int GetY() {
        return y;
    }
    public void StandToField() {
        Calabash.battlefield[x][y] = symbol;
    }
}
