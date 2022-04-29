package Stage;

import Bingo.BingoGame;

import javax.swing.*;

public class WednesdayStage extends BingoGame {
    private JLabel wednesdayBackground;

    public WednesdayStage() {
        super();

        wednesdayBackground = new JLabel();
        wednesdayBackground.setBounds(0, 0, 1310, 715);

        ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("image/Bg3.png")); // เพิ่มBackground
        wednesdayBackground.setIcon(bgIcon);
        add(wednesdayBackground);
    }
}