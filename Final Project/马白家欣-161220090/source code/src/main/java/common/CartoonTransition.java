package common;

import being.*;
import javafx.scene.image.Image;

/**
 * @Description 一些CartoonCharacter的转化函数
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */

public class CartoonTransition {

    private static final String ANSI_SUFFIX = "\033[0m";
    private static final String ANSI_PREFIX = "\033[";
    private static final String ROOT_PATH = "/";

    private static final Image bulletImage = new Image(ROOT_PATH + "Bullet.png");
    private static final Image superBulletImage = new Image(ROOT_PATH + "SuperBullet.png");
    private static final Image redImage = new Image(ROOT_PATH + "Red.jpeg");
    private static final Image orangeImage = new Image(ROOT_PATH + "Orange.jpeg");
    private static final Image yellowImage = new Image(ROOT_PATH + "Yellow.jpeg");
    private static final Image greenImage = new Image(ROOT_PATH + "Green.jpeg");
    private static final Image cyanImage = new Image(ROOT_PATH + "Cyan.jpeg");
    private static final Image blueImage = new Image(ROOT_PATH + "Blue.jpeg");
    private static final Image purpleImage = new Image(ROOT_PATH + "Purple.jpeg");
    private static final Image grandfatherImage = new Image(ROOT_PATH + "GrandFather.jpeg");
    private static final Image scorpionImage = new Image(ROOT_PATH + "Scorpion.jpeg");
    private static final Image snakeImage = new Image(ROOT_PATH + "Snake.jpeg");
    private static final Image lowLevelDemonImage = new Image(ROOT_PATH + "LowLevel.jpeg");
    private static final Image gravestoneImage = new Image(ROOT_PATH + "gravestone.jpeg");

    static public String cartoonCharacterToANSI(CartoonCharacter cartoonCharacter) {
        /**
         * @Description 用来将卡通人物转化成ANSI转义字符，用于控制台显示
         * @Author LUCUS BAI
         * @Date 2018/10/23
         * @Parameters [cartoonCharacter]
         * @ReturnValue java.lang.String
         */
        String returnString = "";
        returnString += ANSI_PREFIX;

        if (cartoonCharacter instanceof Red) {
            returnString += "41;30;4m";
        } else if (cartoonCharacter instanceof Orange) {
            returnString += "43;30;4m";
        } else if (cartoonCharacter instanceof Yellow) {
            returnString += "42;30;4m";
        } else if (cartoonCharacter instanceof Green) {
            returnString += "46;30;4m";
        } else if (cartoonCharacter instanceof Cyan) {
            returnString += "44;30;4m";
        } else if (cartoonCharacter instanceof Blue) {
            returnString += "44;30;4m";
        } else if (cartoonCharacter instanceof Purple) {
            returnString += "45;30;4m";
        } else if (cartoonCharacter instanceof Grandfather) {
            returnString += "40;31;4m";
        } else if (cartoonCharacter instanceof Scorpion) {
            returnString += "47;30;4m";
        } else if (cartoonCharacter instanceof Snake) {
            returnString += "47;30;4m";
        } else if (cartoonCharacter instanceof LowLevelDemon) {
            returnString += "47;30;4m";
        } else {
            return " ";
        }

        returnString += cartoonCharacter.getLabel() + ANSI_SUFFIX;

        return returnString;
    }

    static public Image cartoonCharacterToImage(Being being) {

        /**
         * @Description 用来将卡通人物转化成图片资源文件目录，用于GUI显示
         * @Author LUCUS BAI
         * @Date 2018/10/23
         * @Parameters [cartoonCharacter]
         * @ReturnValue java.lang.String
         */

//        if (being instanceof Bullet) {
//            return ROOT_PATH + "Bullet.png";
//        } else if (being instanceof Red) {
//            return ROOT_PATH + "Red.jpeg";
//        } else if (being instanceof Orange) {
//            return ROOT_PATH + "Orange.jpeg";
//        } else if (being instanceof Yellow) {
//            return ROOT_PATH + "Yellow.jpeg";
//        } else if (being instanceof Green) {
//            return ROOT_PATH + "Green.jpeg";
//        } else if (being instanceof Cyan) {
//            return ROOT_PATH + "Cyan.jpeg";
//        } else if (being instanceof Blue) {
//            return ROOT_PATH + "Blue.jpeg";
//        } else if (being instanceof Purple) {
//            return ROOT_PATH + "Purple.jpeg";
//        } else if (being instanceof Grandfather) {
//            return ROOT_PATH + "GrandFather.jpeg";
//        } else if (being instanceof Scorpion) {
//            return ROOT_PATH + "Scorpion.jpeg";
//        } else if (being instanceof Snake) {
//            return ROOT_PATH + "Snake.jpeg";
//        } else if (being instanceof LowLevelDemon) {
//            return ROOT_PATH + "LowLevel.jpeg";
//        } else {
//            return "";
//        }

//        if (being.getLabel().equals("*")) {
//            return ROOT_PATH + "Bullet.png";
//        } else if (being.getLabel().equals("R")) {
//            return ROOT_PATH + "Red.jpeg";
//        } else if (being.getLabel().equals("O")) {
//            return ROOT_PATH + "Orange.jpeg";
//        } else if (being.getLabel().equals("Y")) {
//            return ROOT_PATH + "Yellow.jpeg";
//        } else if (being.getLabel().equals("G")) {
//            return ROOT_PATH + "Green.jpeg";
//        } else if (being.getLabel().equals("C")) {
//            return ROOT_PATH + "Cyan.jpeg";
//        } else if (being.getLabel().equals("B")) {
//            return ROOT_PATH + "Blue.jpeg";
//        } else if (being.getLabel().equals("P")) {
//            return ROOT_PATH + "Purple.jpeg";
//        } else if (being.getLabel().equals("g")) {
//            return ROOT_PATH + "GrandFather.jpeg";
//        } else if (being.getLabel().equals("S")) {
//            return ROOT_PATH + "Scorpion.jpeg";
//        } else if (being.getLabel().equals("s")) {
//            return ROOT_PATH + "Snake.jpeg";
//        } else if (being.getLabel().equals("L")) {
//            return ROOT_PATH + "LowLevel.jpeg";
//        } else if (being.getLabel().equals(CartoonCharacter.EMPTY_LABEL)) {
//            return "";
//        }
//        else {
//            assert false;
//            return "";
//        }

        if (being.getLabel().equals("*")) {
            return bulletImage;
        } else if(being.getLabel().equals("+")) {
            return superBulletImage;
        } else if (being.getLabel().equals("R")) {
            return redImage;
        } else if (being.getLabel().equals("O")) {
            return orangeImage;
        } else if (being.getLabel().equals("Y")) {
            return yellowImage;
        } else if (being.getLabel().equals("G")) {
            return greenImage;
        } else if (being.getLabel().equals("C")) {
            return cyanImage;
        } else if (being.getLabel().equals("B")) {
            return blueImage;
        } else if (being.getLabel().equals("P")) {
            return purpleImage;
        } else if (being.getLabel().equals("g")) {
            return grandfatherImage;
        } else if (being.getLabel().equals("S")) {
            return scorpionImage;
        } else if (being.getLabel().equals("s")) {
            return snakeImage;
        } else if (being.getLabel().equals("L")) {
            return lowLevelDemonImage;
        } else if (being.getLabel().equals("X")) {
            return gravestoneImage;
        } else if (being.getLabel().equals(CartoonCharacter.EMPTY_LABEL)) {
            return null;
        }
        else {
            assert false;
            return null;
        }
    }
}

