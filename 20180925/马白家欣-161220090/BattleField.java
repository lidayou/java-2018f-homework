package com.homework3;

import javax.swing.*;
import java.awt.*;

public class BattleField {
    public static final int FIELD_SIZE = 15;
    public static final int ICON_SIZE = 40;
    public static final int BORDER_THICKNESS = 1;
    public static final boolean GRAPHICAL_DISPLAY = true;
    public static final int DISPLAY_DELAY = 1000;
    private BattleFieldLattice battleFieldLatticeArray[][] = new BattleFieldLattice[FIELD_SIZE][];
    private JFrame frame;

    public BattleField() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            battleFieldLatticeArray[i] = new BattleFieldLattice[FIELD_SIZE];
        }

        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                Position tempPosition = new Position(i, j);
                battleFieldLatticeArray[i][j] = new BattleFieldLattice(tempPosition);
            }
        }

        frame = new JFrame();
    }

    public void setBattleFieldLattice(Position position, CartoonCharacterInfo cartoonCharacterInfo) {
        int row = position.getRow();
        int col = position.getCol();
        if (row >= 0 && row <= FIELD_SIZE - 1 && col >= 0 && col <= FIELD_SIZE - 1) {
            this.battleFieldLatticeArray[row][col] = new BattleFieldLattice(position, cartoonCharacterInfo);
        }
    }

    public void clearBattleField() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                Position tempPosition = new Position(i, j);
                battleFieldLatticeArray[i][j] = new BattleFieldLattice(tempPosition);
            }
        }
    }

    public void printBattleField() {

        if (GRAPHICAL_DISPLAY == false) {
            for (int k = 0; k < FIELD_SIZE + 2; k++) {
                System.out.print("-");
            }
            System.out.println();
            for (int i = 0; i < FIELD_SIZE; i++) {
                System.out.print("|");
                for (int j = 0; j < FIELD_SIZE; j++) {
                    System.out.printf("%s", battleFieldLatticeArray[i][j].getCartoonCharacter());
                }
                System.out.print("|");
                System.out.println();
            }
            for (int k = 0; k < FIELD_SIZE + 2; k++) {
                System.out.print("-");
            }
            System.out.println();
        } else {

            frame.setSize(FIELD_SIZE * (ICON_SIZE + 2 * BORDER_THICKNESS),
                    FIELD_SIZE * (ICON_SIZE + 2 * BORDER_THICKNESS));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = (JPanel) frame.getContentPane();
            panel.removeAll();
            panel.setLayout(null);

            for(int i = 0; i < FIELD_SIZE ; i++)
            {
                for(int j = 0; j < FIELD_SIZE; j++)
                {
                    ImageIcon icon = new ImageIcon(BattleField.class.getResource("" + battleFieldLatticeArray[i][j].getCartoonCharacter()));
//                    ImageIcon icon =new ImageIcon("" + battleFieldLatticeArray[i][j].getCartoonCharacter());
                    icon.setImage(icon.getImage().getScaledInstance(ICON_SIZE, ICON_SIZE, Image.SCALE_DEFAULT));

                    JLabel label = new JLabel(icon);
                    label.setBorder(BorderFactory.createLineBorder(Color.black, BORDER_THICKNESS));
                    label.setBounds(j * ICON_SIZE,i * ICON_SIZE,ICON_SIZE,ICON_SIZE);
                    panel.add(label);
                }
            }

            frame.setVisible(false);
            frame.setVisible(true);

            try {
                Thread.sleep(DISPLAY_DELAY);
            } catch (Exception e) {
                System.out.println("[ERROR] In BattleGoOn()");
                System.exit(0);//退出程序
            }



        }
    }
}

