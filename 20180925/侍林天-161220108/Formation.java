public class Formation {
    public void generateChangsheFormation(TwoDimensionSpace space, Creature beings[], int x, int y){
        for (int i = 0; i < beings.length; i++){
            beings[i].moveTo(space, x, y-i);
        }
    }
}
