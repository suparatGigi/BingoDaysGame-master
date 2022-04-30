package Main;

import Bingo.BingoGame;
import Bingo.BingoScore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WinScreen extends JPanel {

    public WinScreen() {
        //create continue button
        JButton continueButton = new JButton();
        continueButton.setBounds(330, 120,641,498);
        continueButton.setBackground(null);
        continueButton.setContentAreaFilled(false);
        continueButton.setFocusPainted(false);
        continueButton.setBorderPainted(false);
        continueButton.setToolTipText("CONTINUE");

        ImageIcon continueButtonIcon = new ImageIcon(getClass().getClassLoader().getResource("image/win.png")); // เพิ่มรูปปุ่ม
        continueButton.setIcon(continueButtonIcon);

        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                BingoGame.bingoframe.dispose();
            }
        });

        add(continueButton);
    }
    @Override
    public void paint(Graphics g) {
        repaint();
        Toolkit t = Toolkit.getDefaultToolkit(); //สร้าง Toolkit ไว้ import image
        Image i = t.getImage("src/image/WinandLoseScreen.png");
        Image win = t.getImage("src/image/win.png");


        g.drawImage(i,0,0,1295,715,this);
        g.drawImage(win,330, 120,641,498,this);

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

        //prints message score you will get
        String nextUnlockMessage = " " + BingoScore.scoreYouWillGet();
        g2.drawString(nextUnlockMessage, 670,340);


    }
}
