public class Creature {
    protected String name;
    private int coordinateX;
    private int coordinateY;
    public Creature(){
        coordinateX = -1;
        coordinateY = -1;
        name = "未命名";
    }
    public Creature(String name){
        coordinateX = -1;
        coordinateY = -1;
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void shoutOutName(){
        System.out.println(name);
    }
    public int getCoordinateX(){
        return coordinateX;
    }
    public int getCoordinateY(){
        return coordinateY;
    }
    public void setCoordinate(int x, int y){
        coordinateX = x;
        coordinateY = y;
    }
    public boolean moveTo(TwoDimensionSpace space, int x, int y){
        if (!space.isExceed(x, y)){
            if (space.isEmpty(x, y)) {
                space.setSpace(x, y, this);
                space.cleanSpace(coordinateX, coordinateY);
                coordinateX = x;
                coordinateY = y;
                return true;
            }
        }
        return false;
    }
}
