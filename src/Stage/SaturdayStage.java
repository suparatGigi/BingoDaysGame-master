package Stage;

import Bingo.BingoGame;

import javax.swing.*;
import java.awt.*;


public class SaturdayStage extends BingoGame {
    private JLabel saturdayBackground;

    public SaturdayStage() {
        super();

        saturdayBackground = new JLabel();
        saturdayBackground.setBounds(0, 0, 1310, 715);

        ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("src/image/Bg3.png")); // เพิ่มBackground
        saturdayBackground.setIcon(bgIcon);
        add(saturdayBackground);

    }
}
