package JavaFx;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;

public class BattlefieldController implements Initializable{

    @Override public void initialize(URL location, ResourceBundle resources){
        ChangeLeftChoiceBox.getItems().addAll("HeYI", "YanXing", "HengE", "ChangShe");
        ChangeRightChoiceBox.getItems().addAll("HeYI", "YanXing", "HengE", "ChangShe", "YuLin", "FangYuan", "YanYue", "FengShi");
        BattleFieldFlowPane.setHgap(0);
        BattleFieldFlowPane.setVgap(0);

        ImageView iv1 = new ImageView("http://c.hiphotos.baidu.com/image/pic/item/bf096b63f6246b605ee26e3ce6f81a4c500fa28e.jpg");
        iv1.setFitHeight(50);
        iv1.setFitWidth(80);
        BattleFieldFlowPane.getChildren().add(iv1);
        BattleFieldFlowPane.getChildren().add(iv1);
    }

    @FXML
    FlowPane BattleFieldFlowPane;
    @FXML
    ChoiceBox<String> ChangeLeftChoiceBox;
    @FXML
    ChoiceBox<String> ChangeRightChoiceBox;


}
