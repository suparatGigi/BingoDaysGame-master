package Stage;

import Bingo.BingoGame;

import javax.swing.*;
import java.awt.*;


public class SundayStage extends BingoGame {
    private JLabel sundayBackground;

    public SundayStage() {
        super();

        sundayBackground = new JLabel();
        sundayBackground.setBounds(0, 0, 1310, 715);

        ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("image/bgSun.png")); // เพิ่มBackground
        sundayBackground.setIcon(bgIcon);
        add(sundayBackground);
    }
}
