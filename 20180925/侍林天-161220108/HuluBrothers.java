import java.util.Random;
public class HuluBrothers extends Team{
    private HuluWa member[];
    public HuluBrothers(){
        member = new HuluWa[7];
        for (int i = 0; i < 7; i++){
            member[i] = new HuluWa(i+1);
        }
        Creature grandpa = new Creature("爷爷");
        observer = grandpa;
    }
    public void shoutBrothersName(){
        for (HuluWa h : member){
            h.shoutOutName();
            System.out.print(' ');
        }
        System.out.println();
    }
    public void shoutBrothersColor(){
        for (HuluWa h : member){
            h.shoutOutColor();
            System.out.print(' ');
        }
        System.out.println();
    }
    public void random(){
        Random rand = new Random();
        for (int i = 7; i >= 1; i--){
            int x = rand.nextInt(i);
            HuluWa temp = member[i-1];
            member[i-1] = member[x];
            member[x] = temp;
        }
    }
    public void prioritySort(){
        Sort sort = new Sort();
        sort.bubbleSort(member);
    }
    public void colorSort(){
        Sort sort = new Sort();
        sort.biInsertSort(member);
    }
    public void generateChangshe(TwoDimensionSpace space, int x, int y, int direction){
        Formation formation = new Formation();
        formation.generateChangsheFormation(space, member, x, y, direction);
    }
    public void generateHeyi(TwoDimensionSpace space, int x, int y, int direction){
        Formation formation = new Formation();
        formation.generateHeyiFormation(space, member, x, y, direction);
    }
    public void generateYanhang(TwoDimensionSpace space, int x, int y, int direction){
        Formation formation = new Formation();
        formation.generateYanhangFormation(space, member, x, y, direction);
    }
    public void generateHenge(TwoDimensionSpace space, int x, int y, int direction){
        Formation formation = new Formation();
        formation.generateHengeFormation(space, member, x, y, direction);
    }
}
