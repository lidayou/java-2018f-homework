public class Formation {
    public void generateChangsheFormation(TwoDimensionSpace space, Creature beings[], int x, int y, int direction){
        for (Creature creature : beings){
            space.cleanSpace(creature.getCoordinateX(), creature.getCoordinateY());
        }
        for (int i = 0; i < beings.length; i++){
            //beings[i].shoutOutName();
            if (direction == 0){
                beings[i].moveTo(space, x, y-i);
            } else {
                beings[i].moveTo(space, x, y+i);
            }
        }
    }
    public void generateHeyiFormation(TwoDimensionSpace space, Creature beings[], int x, int y, int direction){
        for (Creature creature : beings){
            space.cleanSpace(creature.getCoordinateX(), creature.getCoordinateY());
            creature.setCoordinate(-1, -1);
        }
        beings[0].moveTo(space, x, y);
        if (direction == 0){
            for (int i = 1; i < beings.length; i++){
                if (i%2 == 0){
                    beings[i].moveTo(space, x+i/2, y+i/2);
                } else {
                    beings[i].moveTo(space, x-i/2-1, y+i/2+1);
                }
            }
        } else {
            for (int i = 1; i < beings.length; i++){
                if (i%2 == 0){
                    beings[i].moveTo(space, x+i/2, y-i/2);
                } else {
                    beings[i].moveTo(space, x-i/2-1, y-i/2-1);
                }
            }
        }
    }
    public void generateYanhangFormation(TwoDimensionSpace space, Creature beings[], int x, int y, int direction){
        for (Creature creature : beings){
            space.cleanSpace(creature.getCoordinateX(), creature.getCoordinateY());
        }
        for (int i = 0; i < beings.length; i++){
            if (direction == 0){
                beings[i].moveTo(space, x-i, y-i);
            } else {
                beings[i].moveTo(space, x+i, y+i);
            }
        }
    }
    public void generateHengeFormation(TwoDimensionSpace space, Creature beings[], int x, int y, int direction){
        for (Creature creature : beings){
            space.cleanSpace(creature.getCoordinateX(), creature.getCoordinateY());
        }
        for (int i = 0; i < beings.length; i++){
            if (direction == 0){
                beings[i].moveTo(space, x+i%2, y-i);
            } else {
                beings[i].moveTo(space, x+i%2, y+i);
            }
        }
    }
}
