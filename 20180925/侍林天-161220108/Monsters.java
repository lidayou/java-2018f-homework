public class Monsters extends Team{
    public Monsters(int n){
        member = new Creature[n+1];
        member[0] = new Creature("蝎子精");
        for (int i = 1; i < member.length; i++){
            member[i] = new Creature("小喽喽");
        }
        observer = new Creature("蛇精");
    }
}
