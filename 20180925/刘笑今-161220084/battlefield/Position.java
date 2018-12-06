//Unused File, Aborted

package battlefield;

import items.Creature;

public class Position {
    private Creature creature;
    private int posX;
    private int posY;

    public Position(){
        creature=null;
        posX=-1;
        posY=-1;
    }
    public Position(Creature creature, int posX, int posY){
        this.creature=creature;
        this.posX=posX;
        this.posY=posY;
    }


    public void setNewPosition(int posX, int posY){
        this.posX=posX;
        this.posY=posY;
    }
    public int getPositionX(){
        return posX;
    }
    public int getPositionY(){
        return posY;
    }

    public void setCreature(Creature creature) {
        this.creature = creature;
    }
}
