package com.homework3;

import java.io.File;

public enum CartoonCharacterInfo {
    VOID(" ",  "", "Void.jpeg"),
    RED("R", "\033[41;30;4m", "Red.jpeg"),
    ORANGE("O", "\033[43;30;4m", "Orange.jpeg"),
    YELLOW("Y", "\033[42;30;4m", "Yellow.jpeg"),
    GREEN("G", "\033[46;30;4m", "Green.jpeg"),
    CYAN("C", "\033[44;30;4m", "Cyan.jpeg"),
    BLUE("B", "\033[44;30;4m", "Blue.jpeg"),
    PURPLE("P", "\033[45;30;4m", "Purple.jpeg"),
    GRANDFATHER("G", "\033[40;31;4m", "GrandFather.jpeg"),
    SNAKE("s", "\033[47;30;4m", "Snake.jpeg"),
    SCORPION("S", "\033[47;30;4m", "Scorpion.jpeg"),
    LOW_LEVEL_DEMON("L", "\033[47;30;4m", "LowLevel.jpeg");

    private String label;
    private String ANSIColorPrefix;
    private String imageName;

    final String ANSI_SUFFIX = "\033[0m";
    final String ROOT_PATH = "/";

    CartoonCharacterInfo(String label, String ANSIColorString, String imageName){
        this.label = label;
        this.ANSIColorPrefix = ANSIColorString;
        this.imageName = imageName;
    }

    @Override
    public String toString() {

        if (BattleField.GRAPHICAL_DISPLAY == false) {
            return this.ANSIColorPrefix + this.label + this.ANSI_SUFFIX;
        } else {
            return this.ROOT_PATH + imageName;
        }
    }
}

