public class Battle{
    public static void main(String[] args) throws InterruptedException{
        Battlefield battlefield = new Battlefield();
        Heroes heroes = new Heroes();
        BadPeople badPeople = new BadPeople();

        heroes.lineUp(battlefield);
        Thread.sleep(1000);

        for(FormationName x:FormationName.values()) {
            badPeople.changeFormation(battlefield, x);
            battlefield.print();
            Thread.sleep(1500);
            badPeople.leaveField(battlefield);
        }
    }
}
