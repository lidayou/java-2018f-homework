package com.company.Formation;

import com.company.BattleField.Coordinate;
import com.company.Tite.Tite;

public interface Formation {
    boolean IfEmpty(Coordinate[][] Field,int x,int y);
    void SetTites(Coordinate[][] Field,int x,int y, Tite[] tites);
}