package com.cjinchi.creature;

import com.cjinchi.util.Cheerful;

public class GrandFather extends Creature implements Cheerful {
    private static GrandFather grandFather;

    private GrandFather() {
        super("“Ø“Ø");
    }

    public static GrandFather getInstance() {
        if (grandFather == null) {
            grandFather = new GrandFather();
        }
        return grandFather;
    }

    public void cheer() {
        System.out.print("º””Õ");
    }
}
