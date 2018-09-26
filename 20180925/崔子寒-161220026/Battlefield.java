public class Battlefield {
    private Block[][] battlefield = new Block[10][20];
    public Battlefield() {
        for(int i = 0;i < 10;i++) {
            for( int j = 0;j < 20;j++) {
                battlefield[i][j] = new Block();
            }
        }
    }

    public Block[][] getBattlefield() {
        return battlefield;
    }

    public void print() {
        for(int i = 0;i < 10;i++) {
            for(int j = 0; j<20 ;j++) {
                battlefield[i][j].outputInfo();
                if(j == 9){
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }
    }

    /*Battlefield Test*/
    /*
    public static void main(String[] args) {
        Battlefield b = new Battlefield();
        b.print();
    }*/
}
