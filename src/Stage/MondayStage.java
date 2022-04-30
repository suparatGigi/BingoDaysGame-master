package Stage;

import Bingo.BingoGame;

import javax.swing.*;
import java.awt.*;


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
}
