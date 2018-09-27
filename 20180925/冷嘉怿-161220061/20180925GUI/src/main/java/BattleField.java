import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Objects;

public class BattleField {

    private JPanel battlefield;
    private Font mfont=new Font("华文楷体",Font.BOLD,25);
    private Scorpion scorption;
    private Grandpa grandpa;
    private Snake snake;
    private Brotherhood brotherhood;
    private boolean Bsorted=false;
    public static void main(String[] args) {
        JFrame frame = new JFrame("BattleField");
        frame.setTitle("葫芦娃兄弟阵法");
        frame.setResizable(false);
        BattleField battle=new BattleField();
        frame.setContentPane(battle.battlefield);
//        battle.scorption=new Scorpion((BackGroundPanel)battle.battlefield);
        frame.setBounds(130,20,1000,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    private void createUIComponents() throws Exception {
        // TODO: place custom component creation code here
        battlefield=new BackGroundPanel();
        battlefield.setBounds(0,0,1000,700);
        battlefield.setLayout(null);
        actionButton button1=new actionButton(800,500,90,80,"monsterhead.PNG","monsterhead2.png");
        button1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                scorption.changeFMT();
                scorption.StandStill();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
        battlefield.add(button1);
        actionButton button2=new actionButton(200,500,90,80,"humanhead.PNG","humanhead2.PNG");
        button2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(Bsorted)
                    brotherhood.randomize();
                else
                    brotherhood.BubbleSort();
                Bsorted=!Bsorted;
                brotherhood.StandStill();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });        battlefield.add(button2);
        scorption=new Scorpion((BackGroundPanel)battlefield);
        grandpa=new Grandpa((BackGroundPanel)battlefield);
        grandpa.StandStill();
        snake=new Snake((BackGroundPanel)battlefield);
        snake.StandStill();
        brotherhood = new Brotherhood((BackGroundPanel) battlefield);
        brotherhood.StandStill();
    }
}

class BackGroundPanel extends JPanel{
    private Image image=(Image)new ImageIcon(this.getClass().getResource("background.jpg")).getImage();
    int deltax=50,deltay=40;
    int xstart=20,ystart=20;
    protected void paintComponent(Graphics g)
    {
        g.drawImage(image,0,0,this.getWidth(),this.getHeight(),this);
    }
}

class actionButton extends JButton{
    private Image img1;
    private Image img2;
    public actionButton(int x, int y, int width, int height, String img1name, String img2name)
    {
        this.setBounds(x,y,width,height);
        ImageIcon imgicon1=new ImageIcon(this.getClass().getResource(img1name));
        ImageIcon imgicon2=new ImageIcon(this.getClass().getResource(img2name));
        imgicon1.setImage(imgicon1.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
        img1=imgicon1.getImage();
        imgicon2.setImage(imgicon2.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
        img2=imgicon2.getImage();
        this.setBorder(null);
        this.setIcon(imgicon1);
        this.setMargin(new Insets(0,0,0,0));
        this.setContentAreaFilled(false);
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                setIcon(imgicon2);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setIcon(imgicon1);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}


/*
class actionButton extends JButton{
    private Image img1;
    private Image img2;
    private boolean pressed=false;
    public actionButton(int x, int y, int width, int height, String img1name, String img2name)
    {
        this.setBounds(x,y,width,height);
        ImageIcon imgicon1=new ImageIcon(this.getClass().getResource(img1name));
        ImageIcon imgicon2=new ImageIcon(this.getClass().getResource(img2name));
        imgicon1.setImage(imgicon1.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
        img1=imgicon1.getImage();
        imgicon2.setImage(imgicon2.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
        img2=imgicon2.getImage();
        this.setBorder(null);
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                pressed=true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                pressed=false;
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
    @Override
    protected void paintComponent(Graphics g)
    {
        if(pressed)
            g.drawImage(img2, 0, 0, this);
        else
            g.drawImage(img1, 0, 0, this);
    }
}
*/