public class Map {
    private Creature[][] map;
    private int size;

    Map(int size){
        this.size=size;
        map = new Creature[size][size];
//        for(int i=0;i<map.length;i++){
//            for(int j=0;j<map[i].length;j++){
//                map[i][j] = 0;
//            }
//        }
    }
    void setCreature(Creature creature, int x, int y){
        map[y][x] = creature;
    }
    void removeCreature(int x, int y){
        map[y][x] = null;
    }
    int getSize(){
        return size;
    }
    void printWholeMap(){
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                if(map[i][j]!=null)
                    map[i][j].print();
                else
                    System.out.print("_ ");
            }
            System.out.print("\n");
        }
    }
}
