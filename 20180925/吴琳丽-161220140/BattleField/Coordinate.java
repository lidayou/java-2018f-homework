package com.company.BattleField;

import com.company.Tite.Tite;

public class Coordinate {
    public int X;
    public int Y;
    public boolean empty;
    public Tite tite;
    Coordinate(){
        X=0;
        Y=0;
        empty=true;
        tite = new Tite();
    }
    Coordinate(int i,int j){
        X=i;
        Y=j;
        empty=true;
        tite = new Tite();
    }
    void PrintTiteName(){
        tite.TitePrintName();
    }
}
