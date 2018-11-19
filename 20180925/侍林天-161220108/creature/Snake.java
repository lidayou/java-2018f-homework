package creature;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Snake extends Demon {
    public Snake() {
        name = "蛇精";
        coordinateX = -1;
        coordinateY = -1;
        imgPath = "src\\image\\snake.jpg";
        try {
            image = ImageIO.read(new File(imgPath));
        }
        catch (IOException e) {
            ;
        }
    }
}
