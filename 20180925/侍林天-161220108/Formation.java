public class Formation {
    public void generateChangsheFormation(TwoDimensionSpace space, Creature beings[], int x, int y, int direction){
        for (Creature creature : beings) {
            creature.removeFrom(space);
        }
        for (int i = 0; i < beings.length; i++) {
            //beings[i].shoutOutName();
            if (direction == 0) {
                beings[i].moveTo(space, x, y - i);
            } else {
                beings[i].moveTo(space, x, y + i);
            }
        }
    }

    public void generateHeyiFormation(TwoDimensionSpace space, Creature beings[], int x, int y, int direction){
        for (Creature creature : beings) {
            creature.removeFrom(space);
        }
        beings[0].moveTo(space, x, y);
        if (direction == 0) {
            for (int i = 1; i < beings.length; i++) {
                if (i % 2 == 0) {
                    beings[i].moveTo(space, x + i / 2, y + i / 2);
                } else {
                    beings[i].moveTo(space, x - i / 2 - 1, y + i / 2 + 1);
                }
            }
        } else {
            for (int i = 1; i < beings.length; i++) {
                if (i % 2 == 0) {
                    beings[i].moveTo(space, x + i / 2, y - i / 2);
                } else {
                    beings[i].moveTo(space, x - i / 2 - 1, y - i / 2 - 1);
                }
            }
        }
    }

    public void generateYanhangFormation(TwoDimensionSpace space, Creature beings[], int x, int y, int direction){
        for (Creature creature : beings) {
            creature.removeFrom(space);
        }
        for (int i = 0; i < beings.length; i++) {
            if (direction == 0) {
                beings[i].moveTo(space, x - i, y - i);
            } else {
                beings[i].moveTo(space, x + i, y + i);
            }
        }
    }

    public void generateHengeFormation(TwoDimensionSpace space, Creature beings[], int x, int y, int direction){
        for (Creature creature : beings) {
            creature.removeFrom(space);
        }
        for (int i = 0; i < beings.length; i++) {
            if (direction == 0) {
                beings[i].moveTo(space, x + i % 2, y - i);
            } else {
                beings[i].moveTo(space, x + i % 2, y + i);
            }
        }
    }
    public void generateYulinFormation(TwoDimensionSpace space, Creature beings[], int x, int y, int direction){
        for (Creature creature : beings) {
            creature.removeFrom(space);
        }
        if (direction == 0){
            int i = 0;
            int k = 0;
            while (i < beings.length){
                for (int j = x; j < x + k && i < beings.length; j++){
                    beings[i].moveTo(space, j, y - k);
                    i++;
                }
                k++;
            }
        } else {
            int i = 0;
            int k = 0;
            while (i < beings.length){
                for (int j = x; j < x + k && i < beings.length; j++){
                    beings[i].moveTo(space, j, y + k);
                    i++;
                }
                k++;
            }
        }

    }
    public void generateFangmenFormation(TwoDimensionSpace space, Creature beings[], int x, int y, int direction){
        for (Creature creature : beings) {
            creature.removeFrom(space);
        }
        beings[0].moveTo(space, x, y);

        if (direction == 0){
            for (int i = 1; i < beings.length / 2; i++){
                if (i % 2 == 0) {
                    beings[i].moveTo(space, x + i / 2 * 2, y + i / 2);
                } else {
                    beings[i].moveTo(space, x - (i / 2 + 1) * 2, y + i / 2 + 1);
                }
            }
            for (int i = beings.length / 2; i < beings.length; i++){
                if (i % 2 == 0) {
                    beings[i].moveTo(space, x + beings.length - i / 2 * 2 + 1, y + i / 2);
                } else {
                    beings[i].moveTo(space, x - beings.length + i / 2 * 2 + 1, y + i / 2 + 1);
                }
            }
        } else {
            for (int i = 1; i < beings.length / 2; i++){
                if (i % 2 == 0) {
                    beings[i].moveTo(space, x + i / 2 * 2, y + i / 2);
                } else {
                    beings[i].moveTo(space, x - (i / 2 + 1) * 2, y + i / 2 + 1);
                }
            }
            for (int i = beings.length / 2; i < beings.length; i++){
                if (i % 2 == 0) {
                    beings[i].moveTo(space, x + beings.length - i / 2 * 2 + 1, y + i / 2);
                } else {
                    beings[i].moveTo(space, x - beings.length + i / 2 * 2 + 1, y + i / 2 + 1);
                }
            }
        }
    }
    public void generateFengshiFormation(TwoDimensionSpace space, Creature beings[], int x, int y, int direction){
        for (Creature creature : beings) {
            creature.removeFrom(space);
        }
        beings[0].moveTo(space, x, y);
        if (direction == 0){
            for (int i = 1; i < beings.length; i++){
                if (i % 3 == 1){
                    beings[i].moveTo(space, x, y- i / 3 - 1);
                } else if (i % 3 == 0) {
                    beings[i].moveTo(space, x - i / 3, y- i / 3);
                } else {
                    beings[i].moveTo(space, x + i / 3 + 1, y- i / 3 - 1);
                }
            }
        } else {
            for (int i = 1; i < beings.length; i++){
                if (i % 3 == 1){
                    beings[i].moveTo(space, x, y + i / 3 + 1);
                } else if (i % 3 == 0) {
                    beings[i].moveTo(space, x - i / 3, y + i / 3);
                } else {
                    beings[i].moveTo(space, x + i / 3 + 1, y + i / 3 + 1);
                }
            }
        }

    }
}
