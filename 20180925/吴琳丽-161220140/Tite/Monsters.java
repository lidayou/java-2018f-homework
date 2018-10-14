package com.company.Tite;

import com.company.Tite.LouLuo;
import com.company.Tite.Tite;
import com.company.Tite.XieZi;

public class Monsters {

    final int LouLuoN = 20;
    public Tite[] monsters = new Tite[LouLuoN];
    public Monsters() {
        monsters[0] = new XieZi();
        for(int i =1; i<LouLuoN; i++){
            monsters[i]=new LouLuo();
        }
    }
}
