enum Color {
    RED("大娃"), ORANGE("二娃"), YELLOW("三娃"), GREEN("四娃"),
    CYAN("五娃"), BLUE("六娃"), PURPLE("七娃");

    final private String name;
    Color(String name) {
        this.name = name;
    }
    String getName() {
        return this.name;
    }
}

enum MonsterCategory {
    MONSTER("小怪"), SNAKE("蛇精"), SCORPION("蝎子");
    final private String name;
    MonsterCategory(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}

class Position {
    public int x;
    public int y;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Position(){
        x = 0;
        y = 0;
    }
}
public class Creature {
    private Position position = new Position();
    public int[] getPosition() {
        int[] temp = {position.x,position.y};
        return temp;
    }

    private void setPosition(int x, int y) {
        position.x = x;
        position.y = y;
    }

    public void outputInfo() {
        System.out.print("生物");
    }

    public void move(Battlefield battlefield, Position newPosition,AttributeofBlock attributeofBlock) {
        battlefield.getBattlefield()[this.position.x][this.position.y].creatureLeave(this);
        battlefield.getBattlefield()[newPosition.x][newPosition.y].creatureEnter(this, attributeofBlock);
        setPosition(newPosition.x, newPosition.y);
    }
}

class CalabashBrother extends Creature {
    private Color color;
    public CalabashBrother(int i) {
        color = Color.values()[i];
    }

    public Color getColor() {
        return color;
    }

    @Override public void outputInfo() {
        System.out.print(color.getName());
    }
}

class GrandFather extends Creature {
    private String name;
    public GrandFather() {
        name = "爷爷";
    }
    @Override public void outputInfo() {
        System.out.print(name);
    }
}

class Monster extends Creature {
    private MonsterCategory category;
    public Monster(MonsterCategory monsterCategory) {
        category = monsterCategory;
    }

    @Override public void outputInfo() {
        System.out.print(category.getName());
    }
}



