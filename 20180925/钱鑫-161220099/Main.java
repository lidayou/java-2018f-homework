package qx;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("请输入战场的大小N（N>10）:");
        int N=sc.nextInt();
        while(N<=10)
        {
            System.out.print("战场太小了，请重新输入：");
            N=sc.nextInt();
        }
        Battlefied battlefied=new Battlefied(N);
        Grandpa gandpa=new Grandpa(0,0);
        battlefied.set(gandpa.getX(),gandpa.getY(),gandpa.getCreatureNameName());
        Monsters snake=new Monsters(N-1,N-1,"蛇精");
        battlefied.set(snake.getX(),snake.getY(),snake.getName());
        CalabashBrothers calabashBrothers=new CalabashBrothers();
        calabashBrothers.BubbleSort();
        Underling underlings=new Underling();
        System.out.print("请选择怪物方的阵型（输入阵型的编号）：\n");
        System.out.print("1、鹤翼\n");
        System.out.print("2、雁行\n");
        System.out.print("3、衡轨\n");
        System.out.print("4、长蛇\n");
        System.out.print("5、鱼鳞\n");
        System.out.print("6、方円\n");
        System.out.print("7、偃月\n");
        System.out.print("8、锋矢\n");
        int no=sc.nextInt();
        while(no>=1&&no<=8)
        {
            Formation formation=new Formation(no,battlefied,calabashBrothers,underlings);
            formation.setCalabashFomation();
            formation.setMonstersFomation();
            battlefied.print();
            System.out.print("可以变换阵型，请选择编号（若输入编号不在1到8之间，则退出）：");
            no=sc.nextInt();
        }

    }
}
