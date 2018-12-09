package qx;

//1、鹤翼 2、雁行 3、衡轨 4、长蛇 5、鱼鳞 6、方円 7、偃月 8、锋矢

public class Formation {
    private int no;
    private Battlefied battlefied;
    private CalabashBrothers calabashBrothers;
    private Underling underlings;
    public Formation(int no,Battlefied battlefied,CalabashBrothers calabashBrothers,Underling underlings)
    {
        this.no=no;
        this.battlefied=battlefied;
        this.calabashBrothers=calabashBrothers;
        this.underlings=underlings;
    }
    public void setCalabashFomation()
    {
        int n=battlefied.getSize();
        battlefied.set((n-1)/2-3,0,calabashBrothers.brothers[0].getName());
        battlefied.set((n-1)/2-2,0,calabashBrothers.brothers[1].getName());
        battlefied.set((n-1)/2-1,0,calabashBrothers.brothers[2].getName());
        battlefied.set((n-1)/2,0,calabashBrothers.brothers[3].getName());
        battlefied.set((n-1)/2+1,0,calabashBrothers.brothers[4].getName());
        battlefied.set((n-1)/2+2,0,calabashBrothers.brothers[5].getName());
        battlefied.set((n-1)/2+3,0,calabashBrothers.brothers[6].getName());
    }
    public void setMonstersFomation()
    {
        int n=battlefied.getSize();
        switch (no)
        {
            case 1:
                battlefied.set((n-1)/2,n-1,underlings.underlings[0].getName());
                for(int i=1;i<=5;i++)
                {
                    battlefied.set((n-1)/2-i,n-1-i,underlings.underlings[i].getName());
                    battlefied.set((n-1)/2+i,n-1-i,underlings.underlings[i].getName());
                }
                break;
            case 2:
                battlefied.set((n-1)/2+3,n-1,underlings.underlings[0].getName());
                for(int i=1;i<=6;i++)
                {
                    battlefied.set((n-1)/2+3-i,n-1-i,underlings.underlings[i].getName());
                }
                break;
            case 3:
                battlefied.set((n-1)/2,n-2,underlings.underlings[0].getName());
                battlefied.set((n-1)/2-3,n-1,underlings.underlings[1].getName());
                battlefied.set((n-1)/2-2,n-2,underlings.underlings[2].getName());
                battlefied.set((n-1)/2-1,n-1,underlings.underlings[3].getName());
                battlefied.set((n-1)/2+1,n-1,underlings.underlings[4].getName());
                battlefied.set((n-1)/2+2,n-2,underlings.underlings[5].getName());
                battlefied.set((n-1)/2+3,n-1,underlings.underlings[6].getName());
                break;
            case 4:
                battlefied.set((n-1)/2,n-1,underlings.underlings[0].getName());
                battlefied.set((n-1)/2-3,n-1,underlings.underlings[1].getName());
                battlefied.set((n-1)/2-2,n-1,underlings.underlings[2].getName());
                battlefied.set((n-1)/2-1,n-1,underlings.underlings[3].getName());
                battlefied.set((n-1)/2+1,n-1,underlings.underlings[4].getName());
                battlefied.set((n-1)/2+2,n-1,underlings.underlings[5].getName());
                battlefied.set((n-1)/2+3,n-1,underlings.underlings[6].getName());
                break;
            case 5:
                battlefied.set((n-1)/2,n-1,underlings.underlings[0].getName());
                battlefied.set((n-1)/2-2,n-2,underlings.underlings[1].getName());
                battlefied.set((n-1)/2-1,n-2,underlings.underlings[2].getName());
                battlefied.set((n-1)/2,n-2,underlings.underlings[3].getName());
                battlefied.set((n-1)/2+1,n-2,underlings.underlings[4].getName());
                battlefied.set((n-1)/2+2,n-2,underlings.underlings[5].getName());
                battlefied.set((n-1)/2-1,n-3,underlings.underlings[6].getName());
                battlefied.set((n-1)/2,n-3,underlings.underlings[7].getName());
                battlefied.set((n-1)/2+1,n-3,underlings.underlings[8].getName());
                battlefied.set((n-1)/2,n-4,underlings.underlings[9].getName());
                break;
            case 6:
                battlefied.set((n-1)/2,n-1,underlings.underlings[0].getName());
                battlefied.set((n-1)/2-1,n-2,underlings.underlings[1].getName());
                battlefied.set((n-1)/2+1,n-2,underlings.underlings[2].getName());
                battlefied.set((n-1)/2-2,n-3,underlings.underlings[3].getName());
                battlefied.set((n-1)/2+2,n-3,underlings.underlings[4].getName());
                battlefied.set((n-1)/2-3,n-4,underlings.underlings[5].getName());
                battlefied.set((n-1)/2+3,n-4,underlings.underlings[6].getName());
                battlefied.set((n-1)/2-2,n-5,underlings.underlings[7].getName());
                battlefied.set((n-1)/2+2,n-5,underlings.underlings[8].getName());
                battlefied.set((n-1)/2-1,n-6,underlings.underlings[9].getName());
                battlefied.set((n-1)/2+1,n-6,underlings.underlings[10].getName());
                battlefied.set((n-1)/2,n-7,underlings.underlings[11].getName());
                break;
            case 7:
                battlefied.set((n-1)/2,n-4,underlings.underlings[0].getName());
                battlefied.set((n-1)/2-4,n-1,underlings.underlings[1].getName());
                battlefied.set((n-1)/2+4,n-1,underlings.underlings[2].getName());
                battlefied.set((n-1)/2-3,n-2,underlings.underlings[3].getName());
                battlefied.set((n-1)/2+3,n-2,underlings.underlings[4].getName());
                battlefied.set((n-1)/2-3,n-3,underlings.underlings[5].getName());
                battlefied.set((n-1)/2+3,n-3,underlings.underlings[6].getName());
                battlefied.set((n-1)/2-2,n-3,underlings.underlings[7].getName());
                battlefied.set((n-1)/2+2,n-3,underlings.underlings[8].getName());
                battlefied.set((n-1)/2-2,n-4,underlings.underlings[9].getName());
                battlefied.set((n-1)/2+2,n-4,underlings.underlings[10].getName());
                battlefied.set((n-1)/2-1,n-4,underlings.underlings[11].getName());
                battlefied.set((n-1)/2+1,n-4,underlings.underlings[12].getName());
                battlefied.set((n-1)/2-1,n-5,underlings.underlings[13].getName());
                battlefied.set((n-1)/2,n-5,underlings.underlings[14].getName());
                battlefied.set((n-1)/2+1,n-5,underlings.underlings[15].getName());
                battlefied.set((n-1)/2-1,n-6,underlings.underlings[16].getName());
                battlefied.set((n-1)/2,n-6,underlings.underlings[17].getName());
                battlefied.set((n-1)/2+1,n-6,underlings.underlings[18].getName());
                break;
            case 8:
                battlefied.set((n-1)/2,n-1,underlings.underlings[0].getName());
                battlefied.set((n-1)/2,n-2,underlings.underlings[1].getName());
                battlefied.set((n-1)/2,n-3,underlings.underlings[2].getName());
                battlefied.set((n-1)/2,n-4,underlings.underlings[3].getName());
                battlefied.set((n-1)/2,n-5,underlings.underlings[4].getName());
                battlefied.set((n-1)/2,n-6,underlings.underlings[5].getName());
                battlefied.set((n-1)/2-1,n-5,underlings.underlings[6].getName());
                battlefied.set((n-1)/2+1,n-5,underlings.underlings[7].getName());
                battlefied.set((n-1)/2-2,n-4,underlings.underlings[8].getName());
                battlefied.set((n-1)/2+2,n-4,underlings.underlings[9].getName());
                break;
        }
    }
}
