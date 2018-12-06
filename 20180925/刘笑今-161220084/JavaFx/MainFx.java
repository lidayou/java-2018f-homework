package JavaFx;

import items.calabash.*;
import items.evil.*;
import items.Creature;
import battlefield.BattleField;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class MainFx extends Application {
    //Static Initialize all creatures here.
    Creature[] calabashbros={new CalabashBro(), new CalabashBro(), new CalabashBro(), new CalabashBro(), new CalabashBro(), new CalabashBro(), new CalabashBro()};
    Creature[] calabashbrosexpred={calabashbros[1],calabashbros[2],calabashbros[3],calabashbros[4],calabashbros[5],calabashbros[6],};
    Creature oldpapa = new OldPapa();
    Creature snakeevil = new SnakeEvil();
    Creature scorpion = new ScorpionEvil();
    Creature[] goblins = new Goblin[20];
    BattleField bf = new BattleField();

    private void initializeAllCreatures(){
        for(int i=0;i<20;i++){
            goblins[i] = new Goblin();
        }
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("battlefield.fxml"));
        primaryStage.setTitle("BattleField");
        primaryStage.setScene(new Scene(root, 600, 700));

        initializeAllCreatures();


        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
