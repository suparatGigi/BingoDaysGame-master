package Bingo;

import javax.swing.*;
import java.awt.*;

public class BingoTable extends JPanel {

    JPanel bingoTable;
    private JLabel[][] bingoLable = new JLabel[4][4];
    JLabel label;

    public BingoTable(){

        setLayout(new GridLayout(4, 4));
        setBounds(0,0,500,200);

        String[] BINGO = {"D", "A", "Y", "S"};
        int[][] playNum = new int[4][4];


        for(int i=0;i<4;i++){
            label = new JLabel();
            label.setText(String.valueOf(BINGO[i]));
            label.setForeground(Color.MAGENTA);
            label.setFont(new Font("TH Sarabun New",Font.BOLD,75));
            label.setBackground(Color.blue);
            label.setOpaque(true);
            label.setVerticalAlignment(JLabel.CENTER);
            label.setHorizontalAlignment(JLabel.CENTER);
            add(label);
        }

        for(int i=0;i<4;i++ ){
            for(int j=0; j<4;j++){
                label = new JLabel();
                label.setText(String.valueOf(playNum[i][j]));
                label.setForeground(Color.black);
                label.setFont(new Font("TH Sarabun New",Font.BOLD,40));
                label.setVerticalAlignment(JLabel.CENTER);
                label.setHorizontalAlignment(JLabel.CENTER);
                add(label);
                bingoLable[i][j]=label;
            }
        }

    }

}
