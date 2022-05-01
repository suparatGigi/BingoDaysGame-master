package Stage;

import Bingo.BingoGame;

import javax.swing.*;

public class TuesdayStage extends BingoGame {
    private JLabel tuesdayBackground;

    public TuesdayStage() {
        super();

        tuesdayBackground = new JLabel();
        tuesdayBackground.setBounds(0, 0, 1310, 715);

        ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("image/stagetue.png")); // เพิ่มBackground
        tuesdayBackground.setIcon(bgIcon);
        add(tuesdayBackground);
    }
}
