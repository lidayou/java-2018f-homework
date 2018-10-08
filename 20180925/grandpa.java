public class grandpa {
    private int x;
    private int y;
    private char symbol;
    grandpa() {
        x = 0;
        y = 0;
        symbol = '@';
    }
    grandpa(int i, int j) {
        x = i;
        y = j;
        symbol = '@';
    }
    public void set_position(int i, int j){
        x = i;
        y = j;
    }
    public char return_symbol(){
        return symbol;
    }
    public int get_x(){
        return x;
    }
    public int get_y(){
        return y;
    }
}
