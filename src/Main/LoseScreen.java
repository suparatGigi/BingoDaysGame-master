package Main;

import Bingo.BingoGame;
import Bingo.BingoScore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoseScreen extends JPanel {

    public LoseScreen() {

        //create continue button
        JButton continueButton = new JButton();
        continueButton.setBounds(343, 134,615,470);
        continueButton.setBackground(null);
        continueButton.setContentAreaFilled(false);
        continueButton.setFocusPainted(false);
        continueButton.setBorderPainted(false);
        continueButton.setToolTipText("CONTINUE");

        ImageIcon continueButtonIcon = new ImageIcon(getClass().getClassLoader().getResource("image/lose.png")); // เพิ่มรูปปุ่ม
        continueButton.setIcon(continueButtonIcon);

        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainDisplay.window.getContentPane().removeAll();
                MainDisplay.window.add(new ChooseStageScreen());
                MainDisplay.window.validate();
            }
        });

        add(continueButton);
    }
    @Override
    public void paint(Graphics g) {
        repaint();
        Toolkit t = Toolkit.getDefaultToolkit(); //สร้าง Toolkit ไว้ import image
        Image i = t.getImage("src/image/WinandLoseScreen.png");
        Image lose = t.getImage("src/image/lose.png");


        g.drawImage(i,0,0,1295,715,this);
        g.drawImage(lose,343, 134,615,470,this);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        Font font = new Font("Franxurter-w11D9.ttf", Font.PLAIN, 45);
        g2.setFont(font);
//
//        try{
//            Font font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("font/Franxurter-w11D9.ttf"));
//            font = font.deriveFont(Font.PLAIN, 100);
//            g2.setFont(font);
//        }
//        catch (Exception error){
//
//        }

        //prints message high score:
        String highScoreMessage = " "+ BingoScore.getHighScore();
        g2.drawString(highScoreMessage, 790,70);

    }
}
