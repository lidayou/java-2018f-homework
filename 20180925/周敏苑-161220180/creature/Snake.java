package creature;
import formation.*;
import java.util.List;

import java.util.ArrayList;

public class Snake extends Leader implements Creature{

    private Position position;
    private String name;

    public Snake(String name){
        this.name = name;
    }

    public void setPosition(Position t){
        position = t;
    }

    public Position getPosition(){
        return position;
    }

    public String getName(){
        return name;
    }

    public void support(){}
    public void check_S_formation(List<Soldier> soldier, String formation){
        switch(formation){
            case "Line": {
                Formation f = new Line();
                f.form_S_formation(soldier);
                break;
            }
            case "Arrow":{
                Formation f = new Arrow();
                f.form_S_formation(soldier);
                break;
            }
            case "Goose":{
                Formation f = new Goose();
                f.form_S_formation(soldier);
                break;
            }
        }
    }
    public void check_C_formation(List<CalabashBrother> soldier, String formation){}
    @Override
    public String toString(){
        return name;
    }
}
