package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreen extends JPanel {
    public static JPanel startScreen;
    private JLabel startBackground;

    public StartScreen() {

        //create start button
        JButton startButton = new JButton();
        startButton.setBounds(550, 450, 200, 89);
        startButton.setBackground(null);
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);
        startButton.setBorderPainted(false);
        startButton.setToolTipText("LET'S GET START");

        ImageIcon startButtonIcon = new ImageIcon(getClass().getClassLoader().getResource("image/startButton.png")); // เพิ่มรูปปุ่ม
        startButton.setIcon(startButtonIcon);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainDisplay.window.getContentPane().removeAll();
                MainDisplay.window.add(new InputNameScreen());
                MainDisplay.window.validate();
            }
        });

        //create how to play Button
        JButton howToPlayButton = new JButton();
        howToPlayButton.setBounds(480, 560, 328, 87);
        howToPlayButton.setBackground(null);
        howToPlayButton.setContentAreaFilled(false);
        howToPlayButton.setFocusPainted(false);
        howToPlayButton.setBorderPainted(false);
        howToPlayButton.setToolTipText("HOW TO PLAY");

        ImageIcon howToPlayButtonIcon = new ImageIcon(getClass().getClassLoader().getResource("image/howTOplaybutton.png")); // เพิ่มรูปปุ่ม
        howToPlayButton.setIcon(howToPlayButtonIcon);

        howToPlayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainDisplay.window.getContentPane().removeAll();
                MainDisplay.window.add(new HowToPlayScreen());
                MainDisplay.window.validate();
            }
        });

        MainDisplay.window.add(startButton);
        MainDisplay.window.add(howToPlayButton);

    }
    public void paint(Graphics g){
        repaint();
        Toolkit t = Toolkit.getDefaultToolkit();
        Image i = t.getImage("src/image/Bg1.png");
        Image sb = t.getImage("src/image/startbutton.png");
        Image hb = t.getImage("src/image/howTOplaybutton.png");

        g.drawImage(i,0,0,this);
        g.drawImage(sb,550, 450, 200, 89,this);
        g.drawImage(hb,480, 560, 328, 87,this);
    }
}