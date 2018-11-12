import java.util.*;

enum Factions {
    EVIL, JUSTICE
}

class Creature {
    String CName;
    private Factions factions;
    private int placeR, placeC;
    private char sign;

    Creature(String CName, Factions factions, char sign) {
        this.CName = CName;
        this.factions = factions;
        placeR = -1;
        placeC = -1;
        this.sign = sign;
    }

    void stepOn(BattleField field, int r, int c) {
        placeC = c;
        placeR = r;
        field.bricks[r][c].sign = sign;
    }

    void leave(BattleField field){
        field.bricks[placeR][placeC].sign = '_';
        placeR = -1;
        placeC = -1;
    }
}

abstract class CreatureQueue {
    abstract void JumpOntoField(BattleField field, Formation form);
}

/*class Underlings extends Creature{
    Underlings() {
        super("小喽啰", Factions.EVIL, 'v');
    }
}*/

class underlingsGenerator implements Generator<Creature>{
    public Creature next()  {
        return new Creature("小喽啰", Factions.EVIL, 'v');
    }
}

class VillainQueue extends CreatureQueue {
    private List<Creature> vlQueue;
    private int numTotal, numOnField;

    VillainQueue(int n) {
        vlQueue = new ArrayList<>();
        vlQueue.add(new Creature("蝎子精", Factions.EVIL, 'w'));

        /*Creature[] underlings = new Creature[n-1];
        for (Creature c:underlings)
            c = new Creature("小喽啰", Factions.EVIL, 'v');    //Arrays.fill()?
        Collections.addAll(vlQueue, underlings);
        */
        Generators.fill(vlQueue, new underlingsGenerator(), n-1);
        numTotal = n;
    }

    void JumpOntoField(BattleField field, Formation form){
        int idx = 0;
        for (int r = 4; r < 15; r++) {
            for (int c = 0; c < 10; c++) {
                if (form.form[r-4][c]){
                    vlQueue.get(idx).stepOn(field, r, c+10);
                    idx++;
                }
            }
        }
        numOnField = idx;
    }

    void leaveField(BattleField field) {
        for (int i = 0; i < numOnField; i++) {
            vlQueue.get(i).leave(field);
        }
        numOnField = 0;
    }
}

enum Color {
    RED("红色"), ORANGE("橙色"),YELLOW("黄色"),
    GREEN("绿色"), CYAN("青色"), BLUE("蓝色"), VIOLET("紫色");

    String CName;
    Color(String CName) {
        this.CName = CName;
    }
}

class CalabashBro extends Creature {
    private Color color;
    private int placeInQue;
    private int seq;

    CalabashBro(String CName, Factions factions, Color color, int seq, int placeInQue, char sign) {
        super(CName, factions, sign);
        this.color = color;
        this.seq = seq;
        this.placeInQue = placeInQue;
    }

    int getSeq() {
        return seq;
    }

    String getName() {
        return CName;
    }

    Color getColor() {
        return color;
    }

    void changePlaceInQue(int idx, boolean report) {
        int oldPlace = placeInQue;
        placeInQue = idx;
        if (report){
            System.out.println(CName + ": " + oldPlace + " -> " + placeInQue);
        }
    }
}

class CBQueue extends CreatureQueue {
    List<CalabashBro> broQueue;

    CBQueue() {
        broQueue = new ArrayList<>();
        broQueue.add(new CalabashBro("老大", Factions.JUSTICE, Color.RED, 1, 0, '1'));
        broQueue.add(new CalabashBro("老二", Factions.JUSTICE, Color.ORANGE, 2, 1, '2'));
        broQueue.add(new CalabashBro("老三", Factions.JUSTICE, Color.YELLOW, 3, 2, '3'));
        broQueue.add(new CalabashBro("老四", Factions.JUSTICE, Color.GREEN, 4, 3, '4'));
        broQueue.add(new CalabashBro("老五", Factions.JUSTICE, Color.CYAN, 5, 4, '5'));
        broQueue.add(new CalabashBro("老六", Factions.JUSTICE, Color.BLUE, 6, 5, '6'));
        broQueue.add(new CalabashBro("老七", Factions.JUSTICE, Color.VIOLET, 7, 6, '7'));

    }

    void randomQueue() {
        /*
        // Knuth Shuffle
        Random rd = new Random();
        for (int i = 6; i > 0; i--) {
            int idx = rd.nextInt(i+1);
            CalabashBro temp = broQueue[idx];
            broQueue[idx] = broQueue[i];
            broQueue[idx].changePlaceInQue(idx, false); // here... changePlace ... need to improve...->Object Oriented
            broQueue[i] = temp;
            broQueue[i].changePlaceInQue(i, false);
        }
        */
        System.out.println("Shuffling...");
        Collections.shuffle(broQueue, new Random(47));
        for (CalabashBro bro : broQueue) {
            int place = broQueue.indexOf(bro);
            bro.changePlaceInQue(place, false);
        }
    }

    void countOffAcName() {
        for (int i = 0; i < 6; i++) {
            System.out.print(broQueue.get(i).getName()+" ");
        }
        System.out.println(broQueue.get(6).getName());
    }

    void countOffAcColor() {
        for (int i = 0; i < 6; i++) {
            System.out.print(broQueue.get(i).getColor().CName+" ");
        }
        System.out.println(broQueue.get(6).getColor().CName);
    }

    void JumpOntoField(BattleField field, Formation form){
        int idx = 0;
        for (int r = 4; r < 15; r++) {
            for (int c = 0; c < 10; c++) {
                if (form.form[r-4][9-c]){
                    broQueue.get(idx).stepOn(field, r, c);
                    idx++;
                }
            }
        }
    }
}