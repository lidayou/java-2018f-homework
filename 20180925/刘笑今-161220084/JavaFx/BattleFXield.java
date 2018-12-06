package JavaFx;

import battlefield.*;
import JavaFx.Pictures.PictureDictionary;
import items.*;
import javafx.scene.image.ImageView;

public class BattleFXield implements PictureDictionary{
    ImageView[][] ImagesOnBattleField = new ImageView[20][20];

    BattleFXield(){
        for(int i=0; i<20; i++){
            for(int j=0; j<20; j++){
                ImagesOnBattleField[i][j] = new ImageView();
                ImagesOnBattleField[i][j].setFitWidth(30);
                ImagesOnBattleField[i][j].setFitHeight(30);
            }
        }
    }


}
