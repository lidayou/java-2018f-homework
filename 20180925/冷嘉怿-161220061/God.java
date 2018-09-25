package ljy.Cucurbit;

import java.util.Random;

public class God {
    private final int CB_NUM=7;     //世界上有七个葫芦娃兄弟
    private Brotherhood brotherhood=new Brotherhood();
    private Scorpion scorpion=new Scorpion();
    private Grandpa grandpa=new Grandpa();
    private Snake snake=new Snake();
    public static void main(String[] args){
        God god=null;
        try{
            god=new God();
        }catch (Exception e){
            e.printStackTrace();
            return;
        }
        god.scorpion.alive=false;
        god.viewField();
        god.brotherhood.BiSort();
        god.viewField();
        god.scorpion.alive=true;
        god.viewField();
        god.scorpion.changeFMT();
        god.viewField();
    }

    God() throws Exception {
        brotherhood.randomize();
    }

    public void viewField()
    {
        BattleField.clear();
        scorpion.StandStill();
        grandpa.StandStill();
        snake.StandStill();
        brotherhood.StandStill();
        BattleField.print();
    }

}
