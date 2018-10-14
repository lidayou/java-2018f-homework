public class Creature {
    protected String name;
    protected int positionX;
    protected int positionY;

    Creature(){
        this.name = "Undefined";
        this.positionX = 0;
        this.positionY = 0;
    }
    Creature(String name){
        this.name = name;
        this.positionX = 0;
        this.positionY = 0;
    }
    Creature(String name, int x, int y){
        this.name = name;
        this.positionX = x;
        this.positionY = y;
    }
    public void changePosition(int x, int y) {
        positionX = x;
        positionY = y;
    }
    public void print(){
        System.out.print("_ ");
    }
}

class CalabashBros extends Creature{
    private int number;
    private String color;

    CalabashBros(int number){
        this.number = number;
        switch (number){
            case 0:name = "老大"; color = "红色"; break;
            case 1:name = "老二"; color = "橙色"; break;
            case 2:name = "老三"; color = "黄色"; break;
            case 3:name = "老四"; color = "绿色"; break;
            case 4:name = "老五"; color = "青色"; break;
            case 5:name = "老六"; color = "蓝色"; break;
            case 6:name = "老七"; color = "紫色"; break;
        }
        //this.name = name;
        //this.color = color;
        this.positionX = 0;
        this.positionY = 0;
    }
    public void print(){
        System.out.print("H ");
    }
}

class GrandFather extends Creature{
    GrandFather(){
        this.name = "老爷爷";
        this.positionX = 0;
        this.positionY = 0;
    }
    public void print(){
        System.out.print("G ");
    }
}

class Snake extends Creature{
    Snake(){
        this.name = "蛇精";
        this.positionX = 0;
        this.positionY = 0;
    }
    public void print(){
        System.out.print("S ");
    }
}

class Scorpion extends Creature{
    Scorpion(){
        this.name = "蝎子精";
        this.positionX = 0;
        this.positionY = 0;
    }
    public void print(){
        System.out.print("X ");
    }
}

class Underling extends Creature{
    private int number;

    Underling(int number){
        this.name = "小喽啰";
        this.number = number;
        this.positionX = 0;
        this.positionY = 0;
    }
    public void print(){
        System.out.print("x ");
    }
}