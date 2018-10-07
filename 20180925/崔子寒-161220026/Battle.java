public class Battle{
    public static void main(String[] args) throws InterruptedException{
        //Create objects
        Battlefield battlefield = new Battlefield();
        Heroes heroes = new Heroes();
        BadPeople badPeople = new BadPeople();
        //heroes line up and enter battlefield
        heroes.lineUp(battlefield);
        Thread.sleep(1000);
        
        //bad people keep changing formation
        for(FormationName x:FormationName.values()) {
            badPeople.changeFormation(battlefield, x);
            battlefield.print();
            Thread.sleep(1500);
        }
    }
}
