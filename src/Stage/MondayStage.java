package Stage;

import Bingo.BingoGame;

import javax.swing.*;
import java.awt.*;


public class MondayStage extends BingoGame {
    private JLabel mondayBackground;

    public MondayStage() {
        super();

        mondayBackground = new JLabel();
        mondayBackground.setBounds(0, 0, 1310, 715);

        ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("src/image/Bg3.png")); // เพิ่มBackground
        mondayBackground.setIcon(bgIcon);
        add(mondayBackground);
    }
    /*
    public void paint(Graphics g) {
        repaint();
        Toolkit t = Toolkit.getDefaultToolkit();
        Image bg = t.getImage("src/image/Bg3.png");

        g.drawImage(bg, 0, 0, this);

    }

     */
}
