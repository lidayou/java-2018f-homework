package calabashBrothers;

import calabashBrothers.beings.Creature;
import calabashBrothers.beings.enums.CalabashName;
import calabashBrothers.beings.enums.EnumCalabashBoy;

import java.awt.Color;
import java.awt.Point;
import java.util.Hashtable;

import javax.swing.*;


/**
 * @ Author     ：Young
 * @ Description：用于展示战场
 */
public class BattleField {

    private JFrame f;
    private int row;
    private int col;
    private int size;
    private int width;
    private int height;
    private Hashtable<String,Integer> nameToRank = new Hashtable<String, Integer>();


    public BattleField(int row, int col, int size) {
        f = new JFrame("葫芦娃 VS 妖怪");
        this.row = row;
        this.col = col;
        this.size = size;
        this.width = (col+1) * size-30;
        this.height = (row+1) * size;
        for (int i = 0; i < 7; i++) {
            nameToRank.put(CalabashName.values()[i].toString(),i);
        }

        f.setSize(width, height);
        //窗口设置位置
        Point point = new Point(350, 200);
        f.setLocation(point);
    }

    JLabel FitInBlank(){
        JLabel tmp = new JLabel();
        tmp.setSize(size, size);
        tmp.setLocation(row*size,col* size);    //设置标签位置
        tmp.setBorder(BorderFactory.createLineBorder(Color.black));  //设置边界为黑色
        return  tmp;
    }

    void ClearBattleField(){
        f.getContentPane().removeAll();
    }

    void ShowBattleField(Maps maps) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                String picPath=new String();
                if(maps.getMaps()[i][j].getCreature()!=null){
                    Creature tmp = maps.getMaps()[i][j].getCreature();
                    switch (tmp.getType()){
                        case CALABASH_BOY:{
                            int rank = nameToRank.get(tmp.getName()) + 1;
//                            System.out.println(rank);
                            picPath = System.getProperty("user.dir")+ "\\src\\static\\pic\\"+rank+".jpg";
//                            picPath = "F:\\大三上\\JAVA程序设计\\hw3_BattleField\\src\\static\\pic\\"+rank+".jpg";
                        }break;

                        case HUMAN_BEING:{
                            picPath = System.getProperty("user.dir")+ "\\src\\static\\pic\\grandpa.jpg";
//                            picPath = "F:\\大三上\\JAVA程序设计\\hw3_BattleField\\src\\static\\pic\\grandpa.jpg";
                        }break;

                        case MONSTER:{
                            picPath = System.getProperty("user.dir")+ "\\src\\static\\pic\\lolo.jpg";
//                            picPath = "F:\\大三上\\JAVA程序设计\\hw3_BattleField\\src\\static\\pic\\lolo.jpg";
                        }break;

                        case MONSTER_LEADER:{
                            if(tmp.getName().equals("蛇精")){
                                picPath = System.getProperty("user.dir")+ "\\src\\static\\pic\\snake.jpg";
//                                picPath = "F:\\大三上\\JAVA程序设计\\hw3_BattleField\\src\\static\\pic\\snake.jpg";
                            }else{
                                picPath = System.getProperty("user.dir")+ "\\src\\static\\pic\\scorpion.jpg";
//                                picPath = "F:\\大三上\\JAVA程序设计\\hw3_BattleField\\src\\static\\pic\\scorpion.jpg";
                            }
                        }break;
                        default:{
                            System.out.println("类型出错");
                        }

                    }
                }else{
                    picPath = System.getProperty("user.dir")+ "\\src\\static\\pic\\back.jpg";
//                    picPath = "F:\\大三上\\JAVA程序设计\\hw3_BattleField\\src\\static\\pic\\back.jpg";
                }
                ImageIcon  icon = new ImageIcon(picPath);
                icon.setImage(icon.getImage().getScaledInstance(size, size,0));
                JLabel l = new JLabel(icon,JLabel.CENTER);
                l.setSize(size, size);
                l.setLocation(j * size, i * size);    //设置标签位置
                l.setBorder(BorderFactory.createLineBorder(Color.black));  //设置边界为黑色
                f.add(l);            //添加标签
            }
        }

        f.add(FitInBlank());            //添加标签
        f.setVisible(true);
    }

}
