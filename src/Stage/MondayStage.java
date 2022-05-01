package Stage;

import Bingo.BingoClick;
import Bingo.BingoGame;
import Bingo.BingoGrid;
import Bingo.BingoNumbers;
import Main.MainDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MondayStage extends BingoGame {
    private JLabel mondayBackground;


    public MondayStage() {
        super();

        mondayBackground = new JLabel();
        mondayBackground.setBounds(0, 0, 1295, 715);

        ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("image/bgmon copy.jpg")); // เพิ่มBackground
        mondayBackground.setIcon(bgIcon);
        add(mondayBackground);


    }

    public void paint(Graphics g){
        repaint();
        Toolkit t = Toolkit.getDefaultToolkit(); //สร้าง Toolkit ไว้ import image
        Image i = t.getImage("src/image/bgmon copy.png");

        g.drawImage(i,0,0,1295,715,this);


    }
}
