import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.ArrayList;
import java.io.*;
import java.awt.*;



public class GUI extends JFrame{
    private ArrayList<ArrayList<JLabel>> blockMatrix;
    public GUI() throws  IOException{
        super("葫芦娃的世界");
        blockMatrix = new ArrayList<>();
        //设置背景图片
        try {
            this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src\\ResourceFiles\\background.jpg")))));
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
                temp.add(new JLabel(new ImageIcon(ImageIO.read(new File("src/ResourceFiles/background.jpg")))));
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

    public void setLabel(int x, int y,String path) throws IOException{
        blockMatrix.get(x).get(y).setText(path);
        try{
            if(path!="") {
                //System.out.println(path);
                blockMatrix.get(x).get(y).setIcon(new ImageIcon(ImageIO.read(new File(path))));
            }
            else {
                blockMatrix.get(x).get(y).setIcon(new ImageIcon(ImageIO.read(new File("src/ResourceFiles/background.jpg"))));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
