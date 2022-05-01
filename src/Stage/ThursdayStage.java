package Stage;

import Bingo.BingoGame;

import javax.swing.*;

public class ThursdayStage extends BingoGame {
    private JLabel thursdayBackground;

    public ThursdayStage() {
        super();

        thursdayBackground = new JLabel();
        thursdayBackground.setBounds(0, 0, 1310, 715);

        ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("image/stagethu.png")); // เพิ่มBackground
        thursdayBackground.setIcon(bgIcon);
        add(thursdayBackground);
    }
}
