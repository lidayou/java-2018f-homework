package creature;
import java.io.*;
import javax.imageio.*;
public class Demon extends Creature {
    public Demon() {
        name = "小喽喽";
        coordinateX = -1;
        coordinateY = -1;
        imgPath = "src\\image\\loulou.jpg";
        try {
            image = ImageIO.read(new File(imgPath));
        }
        catch (IOException e) {
            ;
        }


    }
    public Demon (String name) {
        this.name = name;
        coordinateX = -1;
        coordinateY = -1;
        imgPath = "src\\image\\loulou.jpg";
        try {
            image = ImageIO.read(new File(imgPath));
        }
        catch (IOException e) {
            ;
        }
    }
}
