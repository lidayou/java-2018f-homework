package com.cjinchi.creature;

import com.cjinchi.util.Cheerful;

public class SnakeWoman extends Creature implements Cheerful {
    private static SnakeWoman snakeWoman;

    private SnakeWoman() {
        super("Éß¾«");
    }

    public static SnakeWoman getInstance() {
        if (snakeWoman == null) {
            snakeWoman = new SnakeWoman();
        }
        return snakeWoman;
    }

    public void cheer() {
        System.out.print("¼ÓÓÍ");
    }
}
