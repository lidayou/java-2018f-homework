package com.company.Tite;
import com.company.BattleField.Coordinate;
import com.company.Tite.Grandpa;
import com.company.Tite.SheJing;

import java.util.*;

public class Cheer {

    public static void GCheer(Grandpa grandpa, Coordinate[][] Field, int x, int y){
        Scanner in=new Scanner(System.in);
        while(!Field[x][y].empty){
            System.out.println("爷爷的坐标已被占用");
            System.out.println("请重新输入爷爷的横坐标: ");
            x=in.nextInt();
            System.out.println("请重新输入爷爷的纵坐标:  ");
            y=in.nextInt();
        }
        Field[x][y].tite = grandpa;
        Field[x][y].empty=false;
        grandpa.GrandpaCheers();

    }
    public static void SCheer(SheJing she, Coordinate[][] Field, int x, int y){
        Scanner in=new Scanner(System.in);
        while(!Field[x][y].empty){
            System.out.println("蛇精的坐标已被占用");
            System.out.println("请重新输入蛇精的横坐标: ");
            x=in.nextInt();
            System.out.println("请重新输入蛇精的纵坐标:  ");
            y=in.nextInt();
        }
        Field[x][y].tite = she;
        Field[x][y].empty=false;
        she.SheJingCheers();
    }
}
