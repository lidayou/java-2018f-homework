package ljy.Cucurbit;

public class formations
{
    public int troopsize;
    public int[][] RelativePosition;  //(x,y) pairs
    public int topDistance,bottomDistance,leftDistance,rightDistance;
}
class Fengshi extends formations
{
    public Fengshi(){
        troopsize=18;
        RelativePosition=new int[][]{{1,0},{1,1},{1,-1},{2,0},{2,1},{2,2},{2,-1},{2,-2},
                {3,0},{3,3},{3,-3},{4,0},{4,4},{4,-4},{5,0},{5,4},{5,-4},{6,0}};
        topDistance=4; bottomDistance=4; leftDistance=0; rightDistance=6;
    }
}

class Yanyue extends formations
{
    public Yanyue(){
        troopsize=18;
        RelativePosition=new int[][]{{0,1},{0,-1},{1,0},{1,1},{1,-1},
                {2,0},{2,1},{2,2},{2,-1},{2,-2},{3,2},{3,3},{3,-2},{3,-3},{4,3},{4,-3},
                {5,4},{5,-4}};
        topDistance=4; bottomDistance=4; leftDistance=0; rightDistance=5;
    }
}