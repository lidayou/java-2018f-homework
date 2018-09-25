public class BattleField {
    private TwoDimensionSpace space;
    private HuluBrothers huluBrothers;
    public BattleField(int N){
        space = new TwoDimensionSpace(N);
        huluBrothers = new HuluBrothers();
    }
    public void displayBattleField(){
        space.displaySpace();
    }
    public static void main(String[] args){
        BattleField field = new BattleField(20);
        //field.displayBattleField();
        field.huluBrothers.random();
        field.huluBrothers.generateChangshe(field.space, 0, 8);
        field.displayBattleField();
        System.out.println();
        field.huluBrothers.prioritySort();
        field.huluBrothers.generateChangshe(field.space, 1, 9);
        field.displayBattleField();
    }
}