public class Team {
    protected Creature member[];
    protected Creature observer;
    public Team(){
        ;
    }
    public Team(Creature member[], Creature observer){
        this.member = member;
        this.observer = observer;
    }
    public void generateChangshe(TwoDimensionSpace space, int x, int y){
        for (Creature h : member){
            h.shoutOutName();
        }
       Formation formation = new Formation();
       formation.generateChangsheFormation(space, this.member, x, y);
    }
}
