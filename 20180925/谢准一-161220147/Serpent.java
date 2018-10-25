public class Serpent {
    private int x;
    private int y;
    private char symbol;
    Serpent() {
        x = 0;
        y = 0;
        symbol = '&';
    }
    Serpent(int i, int j) {
        x = i;
        y = j;
        symbol = '&';
    }
    public void set_position(int i, int j) {
        x = i;
        y = j;
    }
    public char return_symbol() {
        return symbol;
    }
}
