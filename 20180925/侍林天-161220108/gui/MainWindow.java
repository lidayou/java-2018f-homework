package gui;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.*;
import java.util.concurrent.TimeUnit;

import space.*;
import creature.*;

public class MainWindow extends JFrame {
    private int size;
    private JLabel field[][];
    private JButton button[];
    private TwoDimensionSpace<Creature> space;
    private ImageIcon background;
    public MainWindow(TwoDimensionSpace<Creature> space) {
        size = space.size();
        this.space = space;
        field = new JLabel[size][size];
        button = new JButton[size];

        setLayout(new GridLayout(size, size));

        try {
            background = new ImageIcon(ImageIO.read(new File("src\\image\\ground.jpg")));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        background.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j] = new JLabel();
                field[i][j].setIcon(background);
                add(field[i][j]);
            }
        }
        /*for (int i = 0; i < size; i++) {
            button[i] = new JButton("123");
            add(button[i]);
        }*/
    }
    public void refresh() {
        try
        {
            TimeUnit.SECONDS.sleep(1);
        }
        catch (Exception e)
        {
            ;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (space.getCreature(i, j) == null) {
                    field[i][j].setIcon(background);
                }
                else {
                    //field[i][j].setText(space.getCreature(i, j).getName());
                    try {
                        ImageIcon image = new ImageIcon(space.getCreature(i, j).getImage());
                        image.setImage(image.getImage().getScaledInstance(50, 40,Image.SCALE_DEFAULT ));
                        field[i][j].setIcon(image);
                    }
                    catch (Exception e) {
                        ;
                    }
                }
            }
        }
    }
}
