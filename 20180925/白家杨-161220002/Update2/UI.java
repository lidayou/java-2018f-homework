package Update2;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Image;
import Update2.Creature.*;
import Update2.Strategy.*;

public class UI {
    final int row = 15;
    final int col = 20;
    private JFrame frame;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JComboBox<Object> godCombox;
    private JComboBox<Object> evilCombox;
    private JTextArea textArea;
    private JSplitPane splitPane;
    private JButton[][] grids;
    //private JRadioButton radio1,
    private Evil demon;
    private God god;
    private ImageIcon HuluwaIcon;
    public void InitCreature(){
        demon = new Evil(this);
        god = new God(this);
    }
    public void InitUI(){
        frame = new JFrame("BJY's Battle");
        frame.setSize(900, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);

        JPanel leftPanel = new JPanel();
        //LeftPanel.setBounds();
        grids = new JButton[row][col];
        HuluwaIcon = new ImageIcon("src/huluwa.jpg");
        HuluwaIcon.setImage(HuluwaIcon.getImage().getScaledInstance(50,50,HuluwaIcon.getImage().SCALE_DEFAULT));
        leftPanel.setLayout(new GridLayout(row, col));

        for(int i = 0; i < grids.length; i++) {
            for(int j = 0; j < grids[i].length; j++) {

                grids[i][j] = new JButton();
                grids[i][j].setBackground(Color.WHITE);
                //grids[i][j].setIcon(icon);
                leftPanel.add(grids[i][j]);
            }
        }


        JPanel rightPanel = new JPanel();
        rightPanel.add(new JLabel("葫芦娃阵型:"));
        godCombox = new JComboBox<>();
        godCombox.addItem("长蛇阵");
        godCombox.addItem("鹤翼阵");
        godCombox.addItem("鱼鳞阵");
        godCombox.addItemListener(god);
        rightPanel.add(godCombox);


        rightPanel.add(new JLabel("妖怪阵型:"));
        evilCombox = new JComboBox<>();
        evilCombox.addItem("长蛇阵");
        evilCombox.addItem("鹤翼阵");
        evilCombox.addItem("鱼鳞阵");
        evilCombox.addItemListener(demon);
        rightPanel.add(evilCombox);
        rightPanel.add(new JLabel("文本区"));
        textArea = new JTextArea(20, 13);// 文本区设置行数和列数
        rightPanel.add(new JScrollPane(textArea));
        // 创建一个水平JSplitPane，左边是p1,右边是p2
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        // 设置分割条的位置
        splitPane.setDividerLocation(500);

        // 把sp当作ContentPane
        frame.setContentPane(splitPane);
        frame.setVisible(true);
    }
    public UI(){
        InitCreature();
        InitUI();
    }

    public void SetCreature(int x_pos, int y_pos, Creature creature){
        String ID = creature.Identity();
        grids[x_pos][y_pos].setIcon(null);
        if(ID.equals("葫芦娃")){
            grids[x_pos][y_pos].setIcon(HuluwaIcon);
            return;
        }
        else if(ID.equals(" 爷爷 ")){
            grids[x_pos][y_pos].setBackground(Color.BLUE);
            return;
        }
        else if (ID.equals("小喽啰")){
            grids[x_pos][y_pos].setBackground(Color.RED);
            return;
        }
        else if(ID.equals("大蛇精")){
            grids[x_pos][y_pos].setBackground(Color.BLACK);
            return;
        }
        else{
            grids[x_pos][y_pos].setBackground(Color.WHITE);
            return;
        }
    }

    public static void main(String[] args){
        UI ui = new UI();

    }
}
