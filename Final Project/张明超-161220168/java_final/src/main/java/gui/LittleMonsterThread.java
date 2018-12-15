package gui;

import beings.BeingImage;
import beings.Grandfather;
import beings.LittleMonster;
import formations.Battlefield;
import javafx.animation.PathTransition;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class LittleMonsterThread extends LittleMonster implements Runnable {
    LittleMonsterThread(Battlefield battlefield){
        this.battlefield = battlefield;
    }
    private void moveForward(){

        battlefield.moveCreature(this.positionx+1, this.positiony, this);
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            //do nothing
        }
    }
    public void run(){
        while(true) {
            moveForward();
            break;
        }
    }
    private Battlefield battlefield;
}
