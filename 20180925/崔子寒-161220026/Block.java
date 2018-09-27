public class Block {
    private Creature creature;
    private boolean empty = true;

    public Block() {
        creature = null;
    }

    public boolean creatureEnter(Creature creature) {
            empty = false;
            this.creature = creature;
            return true;
    }


    public void creatureLeave(Creature creature) {
        if(creature == this.creature) {
            //System.out.println(creature.toString()+" "+this.creature.toString());
            //System.out.println("They are equal");
            empty = true;
            this.creature = null;
        }
    }

    public void outputInfo() {
        if(empty) {
            System.out.print("    ");
        }
        else {
            creature.outputInfo();
        }
    }
}
