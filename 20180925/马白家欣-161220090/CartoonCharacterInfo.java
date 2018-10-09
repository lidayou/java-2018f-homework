package com.homework3;

public enum CartoonCharacterInfo {
    VOID(" ",  ""),
    RED("R", "\033[41;30;4m"),
    ORANGE("O", "\033[43;30;4m"),
    YELLOW("Y", "\033[42;30;4m"),
    GREEN("G", "\033[46;30;4m"),
    CYAN("C", "\033[44;30;4m"),
    BLUE("B", "\033[44;30;4m"),
    PURPLE("P", "\033[45;30;4m"),
    GRANDFATHER("G", "\033[40;31;4m"),
    SNAKE("s", "\033[47;30;4m"),
    SCORPION("S", "\033[47;30;4m"),
    LOW_LEVEL_DEMON("L", "\033[47;30;4m");

    private String label;
    private String ANSIColorPrefix;

    final String ANSI_SUFFIX = "\033[0m";

    CartoonCharacterInfo(String label, String ANSIColorString ){
        this.label = label;
        this.ANSIColorPrefix = ANSIColorString;
    }

    @Override
    public String toString() {
        return this.ANSIColorPrefix + this.label + this.ANSI_SUFFIX;
    }
}

