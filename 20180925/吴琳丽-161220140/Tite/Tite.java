package com.company.Tite;

import com.company.Tite.Color;
import com.company.Tite.Human;

public class Tite {
    public String name;
    public Tite(){
        name="NULL";
    }
    public void TitePrintName(){
        System.out.print(name+" ");
    }
}

class HuluBrother extends Tite{
    private Human HumanHulu;
    public Color color;
    HuluBrother(){
        HumanHulu = Human.ONE;
        name = HumanHulu.getName();
        color = HumanHulu.getColor();
    }
    HuluBrother(int i){
        for (Human c : Human.values()) {
            if (c.ordinal() == i) {
                HumanHulu = c;
            }
        }
        name = HumanHulu.getName();
        color = HumanHulu.getColor();
    }
    public int TellOrdinal(){
        return HumanHulu.ordinal();
    }
    public void HuluTellColor(){
        System.out.println(HumanHulu.getColor());
    }//输出颜色
    public void HuluTellName(){
        System.out.println(HumanHulu.getName());
    }//输出名字

}


class LouLuo extends Tite{
    LouLuo(){
        name="小喽啰";
    }
}

class XieZi extends Tite{
    XieZi(){
        name="蝎子精";
    }
}

