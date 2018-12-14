package gui;


//import battle.BattleCoordinator;
import battle.BattleField;
import battle.BattleFieldLattice;
//import battle.BattleGoOn;
import battle.BattleResult;
import being.Being;
import common.CartoonTransition;
import common.CommonMath;
//import formation.FormationType;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import multithread.BattleMainLoop;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import static being.CartoonCharacter.EMPTY_LABEL;

public class Controller {

    /*常量*/
    private static final Image backgroundImage = new Image("/background.jpg");
    private static final Image winnerCalabashBrothersImage = new Image("/winnerCalabashBrothers.jpeg");
    private static final Image winnerDemonImage = new Image("/winnerDemon.jpeg");
    public static final int FIELD_WIDTH = 10;
    public static final int FIELD_HEIGHT = 8;
    public static final Color LATTICE_FILL_COLOR = Color.rgb(200, 200, 200, 0.5);
    public static final Color LATTICE_STROKE_COLOR = Color.BLACK;
    public static final Color HP_RECT_FILL_COLOR = Color.rgb(0, 255, 0);
    public static final Color HP_RECT_STROKE_COLOR = HP_RECT_FILL_COLOR;
    /*FXML相关变量*/
    @FXML
    private Canvas mainCanvas;

    /*private变量*/
//    private GraphicsContext mainGraphicsContext;
//    private Image backgroundImage;
//    private Rectangle backgroundImageRectangle;
//    private List<Rectangle> latticeRectangleList;

    /*public方法*/
    @FXML
    public void initialize() {
        initBackground(this.mainCanvas);
    }

    @FXML
    public void buttonStartHandler() {
        initialize();
        List<BattleFieldLattice> battleFieldLatticeList = BattleField.getEmptyBattleFieldLatticeList();
        new Thread(new BattleMainLoop(mainCanvas, battleFieldLatticeList, new ReentrantLock(), true)).start();
    }

    @FXML
    public void buttonOpenHandler() {
        initialize();
        List<BattleFieldLattice> battleFieldLatticeList = BattleField.getEmptyBattleFieldLatticeList();
        new Thread(new BattleMainLoop(mainCanvas, battleFieldLatticeList, new ReentrantLock(), false)).start();
    }

    public static synchronized void displayBattleField(Canvas mainCanvas, List<BattleFieldLattice> battleFieldLatticeList){
        initBackground(mainCanvas);
        List<Rectangle> latticeRectangleList = getLatticeRectangleList(getImageRectangle(mainCanvas, backgroundImage));
        GraphicsContext mainGraphicsContext = getGraphicsContext(mainCanvas);
         for (int row = 0; row < FIELD_HEIGHT; row++) {
            for (int col = 0; col < FIELD_WIDTH; col++) {
                Being being = battleFieldLatticeList.get(row * FIELD_WIDTH + col).getBeing();
                Rectangle rectangle = latticeRectangleList.get(row * FIELD_WIDTH + col);

                if (!being.getLabel().equals(EMPTY_LABEL)) {
                    Image image = CartoonTransition.cartoonCharacterToImage(being);
                    if(image != null && being.getLabel().equals("*")) {
                        mainGraphicsContext.drawImage(image,
                                rectangle.getX() + (rectangle.getWidth() - image.getWidth())/2,
                                rectangle.getY() + (rectangle.getHeight() - image.getHeight())/2,
                                image.getWidth(),
                                image.getHeight());
                    }
                    else if(being.getLabel().equals("X")) {
                        mainGraphicsContext.drawImage(image,
                                rectangle.getX(),
                                rectangle.getY(),
                                rectangle.getWidth(),
                                rectangle.getHeight());
                    }
                    else {

                        mainGraphicsContext.drawImage(image,
                                rectangle.getX(),
                                rectangle.getY(),
                                rectangle.getWidth(),
                                rectangle.getHeight());

                        /*绘制血量条*/

                        Rectangle hpRect = new Rectangle(
                                rectangle.getX(),
                                rectangle.getY() + 5 * rectangle.getHeight() / 6,
                                rectangle.getWidth(),
                                rectangle.getHeight() / 6
                        );
                        hpRect.setFill(Color.RED);
                        hpRect.setStroke(HP_RECT_STROKE_COLOR);
                        drawRectangle(mainGraphicsContext, hpRect);

                        hpRect = new Rectangle(
                                rectangle.getX(),
                                rectangle.getY() + 5 * rectangle.getHeight() / 6,
                                (rectangle.getWidth() * being.getRemainedHpRate()) / 100,
                                rectangle.getHeight() / 6
                        );
                        hpRect.setFill(HP_RECT_FILL_COLOR);
                        hpRect.setStroke(HP_RECT_STROKE_COLOR);
                        drawRectangle(mainGraphicsContext, hpRect);
                    }

                }
            }
        }
    }

    public static void displayResults(Canvas mainCanvas, BattleResult battleResult){
        GraphicsContext mainGraphicsContext = getGraphicsContext(mainCanvas);
        Rectangle initRectangle = new Rectangle(0, 0, mainCanvas.getWidth(), mainCanvas.getHeight());
        initRectangle.setFill(Color.WHITE);
        drawRectangle(mainGraphicsContext, initRectangle);

        if(battleResult == BattleResult.CALABASH_BROTHERS) {
            Rectangle backgroundImageRectangle = getImageRectangle(mainCanvas, winnerCalabashBrothersImage);
            mainGraphicsContext.drawImage(winnerCalabashBrothersImage,
                    backgroundImageRectangle.getX(), backgroundImageRectangle.getY(),
                    backgroundImageRectangle.getWidth(), backgroundImageRectangle.getHeight());
        }
        else if (battleResult == BattleResult.DEMON) {
            Rectangle backgroundImageRectangle = getImageRectangle(mainCanvas, winnerDemonImage);
            mainGraphicsContext.drawImage(winnerDemonImage,
                    backgroundImageRectangle.getX(), backgroundImageRectangle.getY(),
                    backgroundImageRectangle.getWidth(), backgroundImageRectangle.getHeight());
        }
        else {
            assert false;
        }
    }

    /*private方法*/
    private static void initBackground(Canvas mainCanvas) {
        GraphicsContext mainGraphicsContext = getGraphicsContext(mainCanvas);
//        Image backgroundImage = getBackgroundImage();
        Rectangle backgroundImageRectangle = getImageRectangle(mainCanvas, backgroundImage);
        mainGraphicsContext.drawImage(backgroundImage,
                backgroundImageRectangle.getX(), backgroundImageRectangle.getY(),
                backgroundImageRectangle.getWidth(), backgroundImageRectangle.getHeight());
        initLattice(backgroundImageRectangle, mainGraphicsContext);
    }

    private static GraphicsContext getGraphicsContext(Canvas mainCanvas) {
        return mainCanvas.getGraphicsContext2D();
    }

//    private static Image getBackgroundImage() {
//        return new Image(BACKGROUND_IMAGE_PATH);
//    }

    private static Rectangle getImageRectangle(Canvas mainCanvas, Image image) {
//        Image backgroundImage = getBackgroundImage();

        double maxWidthHeightProportion= CommonMath.max(
                image.getWidth()/mainCanvas.getWidth(),
                image.getHeight()/mainCanvas.getHeight());
        return new Rectangle(
                (mainCanvas.getWidth() - image.getWidth()/maxWidthHeightProportion) / 2,
                (mainCanvas.getHeight() - image.getHeight()/maxWidthHeightProportion) / 2,
                image.getWidth()/maxWidthHeightProportion,
                image.getHeight()/maxWidthHeightProportion
        );
    }

    private static List<Rectangle> getLatticeRectangleList(Rectangle backgroundImageRectangle) {
        List<Rectangle> latticeRectangleList = new ArrayList<>();
        double doubleLatticeSize = (CommonMath.min(
                backgroundImageRectangle.getWidth() / FIELD_WIDTH,
                backgroundImageRectangle.getHeight() / FIELD_HEIGHT));
        int latticeSize = (int) doubleLatticeSize;
        double halfWidthRedundancy = (backgroundImageRectangle.getWidth() - latticeSize * FIELD_WIDTH) / 2;
        double halfHeightRedundancy = (backgroundImageRectangle.getHeight() - latticeSize * FIELD_HEIGHT) / 2;
        assert halfWidthRedundancy >= 0 && halfHeightRedundancy >= 0;
        for (int row = 0; row < FIELD_HEIGHT; row++) {
            for (int col = 0; col < FIELD_WIDTH; col++) {
                Rectangle rectangle = new Rectangle(
                        backgroundImageRectangle.getX() + halfWidthRedundancy + col * latticeSize,
                        backgroundImageRectangle.getY() + halfHeightRedundancy + row * latticeSize,
                        latticeSize, latticeSize);
                latticeRectangleList.add(rectangle);
            }
        }
        return latticeRectangleList;
    }

    private static void initLattice(Rectangle backgroundImageRectangle, GraphicsContext mainGraphicsContext) {
//        latticeRectangleList.clear();
//        double doubleLatticeSize = (CommonMath.min(
//                backgroundImageRectangle.getWidth() / FIELD_WIDTH,
//                backgroundImageRectangle.getHeight() / FIELD_HEIGHT));
//        int latticeSize = (int) doubleLatticeSize;
//        double halfWidthRedundancy = (backgroundImageRectangle.getWidth() - latticeSize * FIELD_WIDTH) / 2;
//        double halfHeightRedundancy = (backgroundImageRectangle.getHeight() - latticeSize * FIELD_HEIGHT) / 2;
//        assert halfWidthRedundancy >= 0 && halfHeightRedundancy >= 0;
//        for (int row = 0; row < FIELD_HEIGHT; row++) {
//            for (int col = 0; col < FIELD_WIDTH; col++) {
//                Rectangle rectangle = new Rectangle(
//                        backgroundImageRectangle.getX() + halfWidthRedundancy + col * latticeSize,
//                        backgroundImageRectangle.getY() + halfHeightRedundancy + row * latticeSize,
//                        latticeSize, latticeSize);
//                latticeRectangleList.add(rectangle);
//                rectangle.setStroke(LATTICE_STROKE_COLOR);
//                rectangle.setFill(LATTICE_FILL_COLOR);
//                drawRectangle(mainGraphicsContext, rectangle);
//            }
//        }
        List<Rectangle> latticeRectangleList = getLatticeRectangleList(backgroundImageRectangle);
        for (Rectangle aLatticeRectangleList : latticeRectangleList) {
            aLatticeRectangleList.setStroke(LATTICE_STROKE_COLOR);
            aLatticeRectangleList.setFill(LATTICE_FILL_COLOR);
            drawRectangle(mainGraphicsContext, aLatticeRectangleList);
        }
    }

    private static void drawRectangle(GraphicsContext gc, Rectangle rect){
        gc.setFill(rect.getFill());
        gc.setStroke(rect.getStroke());
        gc.strokeRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
        gc.fillRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
    }


}
