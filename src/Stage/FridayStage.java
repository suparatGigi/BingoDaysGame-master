package Stage;

import Bingo.BingoGame;

import javax.swing.*;

public class FridayStage extends BingoGame {
    private JLabel fridayBackground;

    public FridayStage() {
        super();

        fridayBackground = new JLabel();
        fridayBackground.setBounds(0, 0, 1310, 715);

        ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("image/bgFri.png")); // เพิ่มBackground
        fridayBackground.setIcon(bgIcon);
        add(fridayBackground);
    }
}

