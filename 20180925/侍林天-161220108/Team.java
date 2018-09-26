public class Team {
    protected Creature member[];
    protected Creature observer;
    public Team(){
        ;
    }
    public Team(String arg, int n){
        if (arg == "妖怪"){
            member = new Creature[n+1];
            member[0] = new Creature("蝎子精");
            for (int i = 1; i < member.length; i++){
                member[i] = new Creature("小喽喽");
            }
            observer = new Creature("蛇精");
        }
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
    public void generateFangmen(TwoDimensionSpace space, int x, int y, int direction){
        Formation formation = new Formation();
        formation.generateFangmenFormation(space, member, x, y, direction);
    }
    public void generateFengshi(TwoDimensionSpace space, int x, int y, int direction){
        Formation formation = new Formation();
        formation.generateFengshiFormation(space, member, x, y, direction);
    }
    public void generateYulin(TwoDimensionSpace space, int x, int y, int direction){
        Formation formation = new Formation();
        formation.generateYulinFormation(space, member, x, y, direction);
    }
}
