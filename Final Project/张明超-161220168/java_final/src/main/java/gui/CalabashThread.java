package gui;

import beings.BeingImage;
import beings.CalabashBrother;
import beings.Grandfather;
import formations.Battlefield;
import javafx.animation.PathTransition;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class CalabashThread extends CalabashBrother implements Runnable {
    CalabashThread(Battlefield battlefield, int i){
        super(i);
        this.battlefield = battlefield;
    }
    private void moveForward(){

        battlefield.moveCreature(this.positionx+1, this.positiony, this);
        try{
            Thread.sleep(20000);
        }catch (Exception e){
            //do nothing
        }
    }
    public void run(){
        while(true) {
            moveForward();
            //break;
        }
    }
    private Battlefield battlefield;
}
