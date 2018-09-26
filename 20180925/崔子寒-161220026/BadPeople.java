import java.util.Random;

public class BadPeople {
    private Monster[] monsters = new Monster[10];
    public BadPeople() {
        for(int i = 0; i < 8;i++) {
            monsters[i] = new Monster(MonsterCategory.MONSTER);
        }
        monsters[8] = new Monster(MonsterCategory.SNAKE);
        monsters[9] = new Monster(MonsterCategory.SCORPION);
    }

    public void changeFormation(Battlefield battlefield, FormationName formationName) {
        Block[][] field = battlefield.getBattlefield();
        int index = formationName.ordinal();
        for(int i = 0;i < 8; i++) {
            field[Formation.formation[index][i].x][Formation.formation[index][i].y].creatureEnter(monsters[i], AttributeofBlock.MONSTER);
            monsters[i].setPosition(Formation.formation[index][i].x,Formation.formation[index][i].y);
        }

        field[5][0].creatureEnter(monsters[8], AttributeofBlock.MONSTER);
        monsters[8].setPosition(5,0);
        Random rand = new Random();
        int temp_x = 3+rand.nextInt(4);
        field[temp_x][1].creatureEnter(monsters[9],AttributeofBlock.MONSTER);
        monsters[9].setPosition(temp_x,1);
        System.out.println("------------------------------------变阵为："+FormationName.values()[index].getName()+"----------------------------------");
    }

    public void leaveField(Battlefield battlefield) {
        Block[][] field = battlefield.getBattlefield();
        for(Monster x:monsters) {
            int[] temp = x.getPosition();
            field[temp[0]][temp[1]].creatureLeave();
        }
    }
}
