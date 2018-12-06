package JavaFx;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;

public class BattlefieldController implements Initializable{

    @Override public void initialize(URL location, ResourceBundle resources){
        ChangeDeploymentLeftChoiceBox = new ChoiceBox<>();
        ChangeDeploymentLeftChoiceBox.getItems().add("HeYi");
        System.out.println("Execute Here!");
    }
    @FXML
    FlowPane BattleFieldFlowPane;

    @FXML
    ChoiceBox<String> ChangeDeploymentLeftChoiceBox;

    @FXML
    ChoiceBox<String> ChangeDeploymentRightChoiceBox;

    void initializeBattleFieldFlowPane(){
        BattleFieldFlowPane = new FlowPane();
        ChangeDeploymentLeftChoiceBox = new ChoiceBox<>(FXCollections.observableArrayList("HeYI", "YanXing", "HengE", "ChangShe"));
        ChangeDeploymentRightChoiceBox = new ChoiceBox<>(FXCollections.observableArrayList("HeYI", "YanXing", "HengE", "ChangShe", "YuLin", "FangYuan", "YanYue", "FengShi"));
    }
}
