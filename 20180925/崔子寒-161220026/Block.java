enum AttributeofBlock{
    EMPTY, CALA, GRANDFATHER, MONSTER;
}
public class Block {
    private AttributeofBlock attribute;
    private Object creature;
    private boolean empty = true;

    public Block() {
        attribute = AttributeofBlock.EMPTY;
        creature = null;
    }

    public boolean creatureEnter(Creature creature, AttributeofBlock attribute) {
        if(! empty) {
            return false;
        }
        else {
            empty = true;
            this.attribute = attribute;
            this.creature = creature;
            return true;
        }
    }

    public void creatureLeave() {
        empty = true;
        creature = null;
        attribute = AttributeofBlock.EMPTY;
    }

    public void outputInfo() {
        switch (attribute){
            case EMPTY: System.out.print("    ");return;
            case CALA: CalabashBrother tempCala = (CalabashBrother)creature;tempCala.outputInfo(); return;
            case GRANDFATHER: GrandFather tempGrandFather = (GrandFather)creature;tempGrandFather.outputInfo(); return;
            case MONSTER: Monster tempMonster = (Monster)creature; tempMonster.outputInfo();
        }
    }

    /*Block Test*/

}
