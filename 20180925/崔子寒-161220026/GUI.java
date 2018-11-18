import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.ArrayList;
import java.io.*;
import java.awt.*;

public class GUI extends JFrame{
    private ArrayList<ArrayList<JLabel>> blockMatrix;
    private ArrayList<ImageIcon> calaBashIcons;
    private ImageIcon monsterIcon;
    private ImageIcon snakeIcon;
    private ImageIcon scorpionIcon;
    private ImageIcon backgroubdIcon;
    private ImageIcon grandFatherIcon;
    public GUI() throws  IOException{
        super("葫芦娃的世界");
        blockMatrix = new ArrayList<>();
        calaBashIcons = new ArrayList<>();
        //设置读入图片数据
        try {
            calaBashIcons.add(new ImageIcon(ImageIO.read(new File("src/ResourceFiles/1.jpg"))));
            calaBashIcons.add(new ImageIcon(ImageIO.read(new File("src/ResourceFiles/2.jpg"))));
            calaBashIcons.add(new ImageIcon(ImageIO.read(new File("src/ResourceFiles/3.jpg"))));
            calaBashIcons.add(new ImageIcon(ImageIO.read(new File("src/ResourceFiles/4.jpg"))));
            calaBashIcons.add(new ImageIcon(ImageIO.read(new File("src/ResourceFiles/5.jpg"))));
            calaBashIcons.add(new ImageIcon(ImageIO.read(new File("src/ResourceFiles/6.jpg"))));
            calaBashIcons.add(new ImageIcon(ImageIO.read(new File("src/ResourceFiles/7.jpg"))));
            monsterIcon = new ImageIcon(ImageIO.read(new File("src/ResourceFiles/monster.png")));
            snakeIcon = new ImageIcon(ImageIO.read(new File("src/ResourceFiles/snake.jpg")));
            scorpionIcon = new ImageIcon(ImageIO.read(new File("src/ResourceFiles/scorpion.png")));
            backgroubdIcon = new ImageIcon(ImageIO.read(new File("src/ResourceFiles/background.jpg")));
            grandFatherIcon = new ImageIcon(ImageIO.read(new File("src/ResourceFiles/grandfather.jpg")));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(-2);
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1050,700);
        setResizable(false);
        setLayout(new GridLayout(10,15));
        for(int i = 0;i<10;i++) {
            ArrayList<JLabel> temp = new ArrayList<>();
            for(int j =0;j<15;j++) {
                JLabel jLabel = new JLabel();
                jLabel.setIcon(backgroubdIcon);
                temp.add(jLabel);
            }
            blockMatrix.add(temp);
        }
        for(ArrayList<JLabel> labels:blockMatrix) {
            for(JLabel jLabel: labels) {
                add(jLabel);
            }
        }
        setVisible(true);
    }

    public void setLabel(int x, int y,int index) {
        switch (index){
            case -1:
                blockMatrix.get(x).get(y).setIcon(backgroubdIcon);
                break;
            case 7:
                blockMatrix.get(x).get(y).setIcon(snakeIcon);
                break;
            case 8:
                blockMatrix.get(x).get(y).setIcon(scorpionIcon);
                break;
            case 9:
                blockMatrix.get(x).get(y).setIcon(monsterIcon);
                break;
            case 10:
                blockMatrix.get(x).get(y).setIcon(grandFatherIcon);
                break;
            default:
                blockMatrix.get(x).get(y).setIcon(calaBashIcons.get(index));
                break;
        }
    }
}
