import java.util.Random;

public class BadPeople {
    private Monster[] monsters = new Monster[10];
    /*create 8 common monsters, a snake, a scorpion*/
    public BadPeople() {
        for(int i = 0; i < 8;i++) {
            monsters[i] = new Monster(MonsterCategory.MONSTER);
        }
        monsters[8] = new Monster(MonsterCategory.SNAKE);
        monsters[9] = new Monster(MonsterCategory.SCORPION);
    }

    /*change the formation defined by formationName*/
    public void changeFormation(Battlefield battlefield, FormationName formationName) {
        int index = formationName.ordinal();
        for(int i = 0;i < 8; i++) {
            monsters[i].move(battlefield, Formation.formation[index][i]);
            //System.out.println("monster"+i+" move to "+ Formation.formation[index][i].x+" "+ Formation.formation[index][i].y);
        }

        Position positionOfSnake = new Position(5,0);
        monsters[8].move(battlefield,positionOfSnake);

        Random rand = new Random();
        int temp_x = 3+rand.nextInt(4);

        Position positionOfScorpion = new Position(temp_x, 1);
        monsters[9].move(battlefield, positionOfScorpion);

        System.out.println("------------------------------------变阵为："+FormationName.values()[index].getName()+"----------------------------------");
    }

   /* public void leaveField(Battlefield battlefield) {
        Block[][] field = battlefield.getBattlefield();
        for(Monster x:monsters) {
            int[] temp = x.getPosition();
            field[temp[0]][temp[1]].creatureLeave();
        }
    }*/
}
