/*The unit size of space*/ 
public class Block {
    /*The creature stands on it*/ 
    private Creature creature;
    private boolean empty = true;

    public Block() {
        creature = null;
    }
    /*creature enter*/
    public boolean creatureEnter(Creature creature) {
            empty = false;
            this.creature = creature;
            return true;
    }

    /*creature leave*/ 
    public void creatureLeave(Creature creature) {
        if(creature == this.creature) {
            //System.out.println(creature.toString()+" "+this.creature.toString());
            //System.out.println("They are equal");
            empty = true;
            this.creature = null;
        }
    }

    /*output the information of the creature*/
    public void outputInfo() {
        if(empty) {
            System.out.print("    ");
        }
        else {
            creature.outputInfo();
        }
    }
}
