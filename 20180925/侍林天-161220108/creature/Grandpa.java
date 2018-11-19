package creature;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Grandpa extends Creature {
    public Grandpa() {
        name = "爷爷";
        coordinateX = -1;
        coordinateY = -1;
        imgPath = "src\\image\\grandpa.jpg";
        try {
            image = ImageIO.read(new File(imgPath));
        }
        catch (IOException e) {
            ;
        }
    }
}
